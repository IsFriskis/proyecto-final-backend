package es.tfc.marcosm.application.servicios;

import es.tfc.marcosm.domain.dto.BanDTO;
import es.tfc.marcosm.domain.dto.WarnDTO;
import es.tfc.marcosm.domain.dto.WarnLevelDTO;
import es.tfc.marcosm.domain.repository.BanRepository;
import es.tfc.marcosm.domain.repository.WarnLevelRepository;
import es.tfc.marcosm.domain.repository.WarnRepository;
import es.tfc.marcosm.domain.service.WarnServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WarnService implements WarnServiceInterface {

    private final Integer LEVE = 1;
    private final Integer MEDIO = 3;
    private final Integer GRAVE = 5;
    private final Integer CEILING = 9;

    private final String DEFAULT_BAN_TITLE = "Acumulación de warns";
    private final String DEFAULT_BAN_DESCRIPTION = "Este ban se aplica a la persona que ha acumulado un número de warns";

    @Autowired
    private final WarnRepository warnRepository;

    @Autowired
    private final WarnLevelRepository warnLevelRepository;

    @Autowired
    private final BanRepository banRepository;

    @Override
    public List<WarnDTO> selectAllWarns(){
        return warnRepository.selectAllWarns();
    }

    @Override
    public WarnDTO selectWarnById(Integer id){
        return warnRepository.selectWarnById(id);
    }

    @Override
    public WarnDTO createWarn(WarnDTO warnDTO){
        List<WarnDTO> warns = warnRepository.selectWarnByUserId(warnDTO.getUserId());
        warns.add(warnDTO);
        if(checkIfBan(warns)){
            BanDTO banDTO = new BanDTO();
            banDTO.setTitle(DEFAULT_BAN_TITLE);
            banDTO.setDescription(DEFAULT_BAN_DESCRIPTION);
            banDTO.setUserId(warnDTO.getUserId());

            banRepository.createBan(banDTO);
        }
        return warnRepository.createWarn(warnDTO);
    }

    private boolean checkIfBan(List<WarnDTO> warns) {
        Integer counter = 0;
        for (WarnDTO warn: warns) {
            WarnLevelDTO warnLevelDTO = warnLevelRepository.selectWarnLevelById(warn.getWarnLevelId());
            switch (warnLevelDTO.getName()) {
                case "Leve":
                    counter += LEVE;
                    break;
                case "Medio":
                    counter += MEDIO;
                    break;
                case "Grave":
                    counter += GRAVE;
                    break;
                default:
                    break;
            }
        }
        if(counter >= CEILING){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public WarnDTO updateWarn(Integer id, WarnDTO warnDTO){
        warnDTO.setId(id);
        return warnRepository.updateWarn(warnDTO);
    }

    @Override
    public String deleteWarn(Integer id){
        return warnRepository.deleteWarn(id);
    }

    @Override
    public WarnDTO selectWarnByObject(WarnDTO warnDTO){
        return warnRepository.selectWarnByObject(warnDTO);
    }

    @Override
    public Integer selectWarnsAmountByUserId(String userId){
        return warnRepository.selectWarnsAmountByUserId(userId);
    }
}
