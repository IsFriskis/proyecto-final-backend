package es.tfc.marcosm.apirest.controller;

import es.tfc.marcosm.apirest.mapper.WarnMapperTO;
import es.tfc.marcosm.apirest.to.UserTO;
import es.tfc.marcosm.apirest.to.WarnTO;
import es.tfc.marcosm.domain.service.WarnServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/warn")
public class WarnController {

    @Autowired
    private final WarnServiceInterface warnService;

    @Autowired
    private final WarnMapperTO warnMapper;

    @GetMapping(value = "/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("WarnController Up", getHeader(), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<WarnTO> selectAllWarns() {
        return warnMapper.toTOList(warnService.selectAllWarns());
    }

    @GetMapping(value = "/{id}")
    public WarnTO selectWarnById(@PathVariable("id") Integer id) {
        return warnMapper.toTO(warnService.selectWarnById(id));
    }

    @PostMapping(value = "/create")
    public WarnTO createWarn(@RequestBody WarnTO warnTO) {
        return warnMapper.toTO(warnService.createWarn(warnMapper.toDTO(warnTO)));
    }

    @PutMapping(value = "/update/{id}")
    public WarnTO updateWarn(@PathVariable Integer id, @RequestBody WarnTO warnTO) {
        return warnMapper.toTO(warnService.updateWarn(id, warnMapper.toDTO(warnTO)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteWarn(@PathVariable Integer id) {
        return warnService.deleteWarn(id);
    }

    @GetMapping(value = "/all/{userId}")
    public Integer selectWarnsAmountByUserId(@PathVariable String userId) {
        return warnService.selectWarnsAmountByUserId(userId);
    }

    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        headers.add("Access-Control-Allow-Origin"," http://localhost:3000");
        return headers;
    }
}
