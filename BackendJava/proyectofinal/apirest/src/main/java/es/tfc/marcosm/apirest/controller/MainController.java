package es.tfc.marcosm.apirest.controller;

import es.tfc.marcosm.domain.service.MainServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/general")
public class MainController {

    @Autowired
    private final MainServiceInterface mainService;

    @GetMapping(value = "/status")
    public ResponseEntity<String> status() {
        if(mainService.allControllerStatus()) {
            return new ResponseEntity<>("AllControllers Up", getHeader(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Service Unavailable", getHeader(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        return headers;
    }
}
