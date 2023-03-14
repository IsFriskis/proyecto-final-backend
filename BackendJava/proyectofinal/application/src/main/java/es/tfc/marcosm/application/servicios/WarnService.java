package es.tfc.marcosm.application.servicios;

import es.tfc.marcosm.domain.dto.WarnDTO;
import es.tfc.marcosm.domain.repository.WarnRepository;
import es.tfc.marcosm.domain.service.WarnServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WarnService implements WarnServiceInterface {

    @Autowired
    private final WarnRepository warnRepository;

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
        //TODO: check how many warns there are.Converte to integer references and add ban
        return warnRepository.createWarn(warnDTO);
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
}
