package es.tfc.marcosm.apirest.controller;

import es.tfc.marcosm.apirest.mapper.PlayerCardMapperTO;
import es.tfc.marcosm.apirest.mapper.UserMapperTO;
import es.tfc.marcosm.apirest.to.PlayerCardTO;
import es.tfc.marcosm.apirest.to.UserTO;

import es.tfc.marcosm.domain.service.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserServiceInterface userService;

    @Autowired
    private final UserMapperTO userMapper;

    @Autowired
    private final PlayerCardMapperTO playerCardMapper;


    @GetMapping(value = "/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("UserController Up", getHeader(), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<UserTO> selectAllUsers() {
        return userMapper.toTOList(userService.selectAllUsers());
    }

    @GetMapping(value = "/{id}")
    public UserTO selectUserById(@PathVariable String id) {
        return userMapper.toTO(userService.selectUserById(id));
    }

    @PostMapping(value = "/create")
    public UserTO createUser(@RequestBody UserTO userTO) {
        return userMapper.toTO(userService.createUser(userMapper.toDTO(userTO)));
    }

    @PutMapping(value = "/update/{id}")
    public UserTO updateUser(@PathVariable String id, @RequestBody UserTO userTO) {
        return userMapper.toTO(userService.updateUser(id, userMapper.toDTO(userTO)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "El usuario con la id: " + id + " ha sido eliminado";
    }

    @GetMapping(value = "/{username}/{page}/{offset}")
    public List<PlayerCardTO> selectUsersByNameFilter(@PathVariable String username, @PathVariable Integer page, @PathVariable Integer offset){
        return playerCardMapper.toTOList(userService.selectUsersByNameFilter(username, page, offset));
    }
    @GetMapping(value = "/{username}/{page_size}")
    public Integer selectPageLimit(@PathVariable String username, @PathVariable Integer page_size){
        return userService.selectPageableLimit(username, page_size);
    }

    @GetMapping(value = "/playercards")
    public ResponseEntity<List<PlayerCardTO>> selectUsersByNameFilter() {
        return new ResponseEntity<>(playerCardMapper.toTOList(userService.selectUsersWithPlayerCard()), getHeader(), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/login/{email}/{password}")
    public  ResponseEntity<UserTO> loginProcess(@PathVariable String email, @PathVariable String password) throws Exception {
        UserTO user = userMapper.toTO(userService.loginProcess(email, password));
        if(user == null){
            return new ResponseEntity<>(user, getHeader(), HttpStatus.EXPECTATION_FAILED);
        }else{
            return new ResponseEntity<>(user, getHeader(), HttpStatus.ACCEPTED);
        }
    }

    @PostMapping(value = "/register/{username}/{email}/{password}")
    public ResponseEntity<UserTO> registerProcess(@PathVariable String username, @PathVariable String email, @PathVariable String password){
        UserTO user = userMapper.toTO(userService.registerProcess(username, email, password));
        if(user == null){
            return new ResponseEntity<>(user, getHeader(), HttpStatus.EXPECTATION_FAILED);
        } else{
            return new ResponseEntity<>(user, getHeader(), HttpStatus.ACCEPTED);
        }
    }

    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        headers.add("Access-Control-Allow-Origin"," http://localhost:3000");
        return headers;
    }
}
