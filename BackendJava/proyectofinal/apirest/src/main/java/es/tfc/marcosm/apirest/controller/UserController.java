package es.tfc.marcosm.apirest.controller;

import es.tfc.marcosm.apirest.mapper.UserMapperTO;
import es.tfc.marcosm.apirest.to.UserTO;
import es.tfc.marcosm.domain.service.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        return headers;
    }
}
