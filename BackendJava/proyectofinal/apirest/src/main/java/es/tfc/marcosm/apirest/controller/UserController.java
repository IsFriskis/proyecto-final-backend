package es.tfc.marcosm.apirest.controller;

import es.tfc.marcosm.apirest.mapper.UserMapperTO;
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

    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        return headers;
    }
}
