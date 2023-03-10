package es.tfc.marcosm.apirest.controller;

import es.tfc.marcosm.apirest.mapper.WarnLevelMapperTO;
import es.tfc.marcosm.apirest.to.WarnLevelTO;
import es.tfc.marcosm.domain.service.WarnLevelServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    public WarnLevelTO selectWarnLevelById(@PathVariable Integer id){
        return warnLevelMapper.toTO(warnLevelService.selectWarnLevelById(id));
    }



    @PostMapping(value = "/create")
    public WarnLevelTO createWarnLevel(@RequestBody WarnLevelTO warnLevelTO){
        return warnLevelMapper.toTO(warnLevelService.createWarnLevel(warnLevelMapper.toDTO(warnLevelTO)));
    }

    @PutMapping(value = "/update/{id}")
    public WarnLevelTO updateWarnLevel(@PathVariable Integer id, @RequestBody WarnLevelTO warnLevelTO){
        return warnLevelMapper.toTO(warnLevelService.updateWarnLevel(id, warnLevelMapper.toDTO(warnLevelTO)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteWarnLevel(@PathVariable Integer id){
        return warnLevelService.deleteWarnLevel(id);
    }

    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        return headers;
    }
}
