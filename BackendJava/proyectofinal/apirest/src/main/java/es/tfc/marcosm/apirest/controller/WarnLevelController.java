package es.tfc.marcosm.apirest.controller;

import es.tfc.marcosm.apirest.mapper.WarnLevelMapperTO;
import es.tfc.marcosm.apirest.to.WarnLevelTO;
import es.tfc.marcosm.domain.service.WarnLevelServiceInterface;
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
@RequestMapping("/warnlevel")
public class WarnLevelController {

    @Autowired
    private final WarnLevelServiceInterface warnLevelService;

    @Autowired
    private final WarnLevelMapperTO warnLevelMapper;

    @GetMapping(value = "/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("WarnLevelController Up", getHeader(), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<WarnLevelTO> selectAllWarnLevels(){
        return warnLevelMapper.toTOList(warnLevelService.selectAllWarnLevels());
    }
    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        return headers;
    }
}
