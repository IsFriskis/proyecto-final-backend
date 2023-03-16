package es.tfc.marcosm.apirest.controller;

import es.tfc.marcosm.apirest.mapper.BanMapperTO;
import es.tfc.marcosm.apirest.to.BanTO;
import es.tfc.marcosm.domain.service.BanServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ban")
public class BanController {

    @Autowired
    private final BanServiceInterface banService;

    @Autowired
    private final BanMapperTO banMapperTO;

    @GetMapping("/all")
    public List<BanTO> selectAllBan(){
        return banMapperTO.toTOList(banService.selectAllBans());
    }

    @GetMapping("/{id}")
    public BanTO selectBanById(@PathVariable Integer id){
        return banMapperTO.toTO(banService.selectBanById(id));
    }

    @PostMapping("/create")
    public BanTO insertBan(@RequestBody BanTO banTO){
        return banMapperTO.toTO(banService.createBan(banMapperTO.toDTO(banTO)));
    }

    @PutMapping("/close/{id}")
    public String closeBan(@PathVariable Integer id){
        return banService.closeBan(id);
    }

    @PutMapping("/udpate/{id}")
    public BanTO updateBan(@PathVariable Integer id, @RequestBody BanTO banTO){
        return banMapperTO.toTO(banService.updateBan(id, banMapperTO.toDTO(banTO)));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBan(@PathVariable Integer id){
        return banService.deleteBan(id);
    }

    @PatchMapping("/reviewed/{id}")
    public String setReviewedBan(@PathVariable Integer id){
        return banService.setReviewedBan(id);
    }

}
