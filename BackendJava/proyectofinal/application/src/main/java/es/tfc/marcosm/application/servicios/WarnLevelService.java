package es.tfc.marcosm.application.servicios;

import es.tfc.marcosm.domain.dto.WarnLevelDTO;
import es.tfc.marcosm.domain.repository.WarnLevelRepository;
import es.tfc.marcosm.domain.service.WarnLevelServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class WarnLevelService implements WarnLevelServiceInterface {

    @Autowired
    private final WarnLevelRepository warnLevelRepository;

    @Override
    public List<WarnLevelDTO> selectAllWarnLevels(){
        return warnLevelRepository.selectAllWarnLevels();
    }

    @Override
    public WarnLevelDTO selectWarnLevelById(Integer id){
        return warnLevelRepository.selectWarnLevelById(id);
    }

    @Override
    public WarnLevelDTO createWarnLevel(WarnLevelDTO warnLevelDTO){
        return warnLevelRepository.createWarnLevel(warnLevelDTO);
    }

    @Override
    public WarnLevelDTO updateWarnLevel(Integer id, WarnLevelDTO warnLevelDTO){
        warnLevelDTO.setId(id);
        return warnLevelRepository.updateWarnLevel(warnLevelDTO);
    }

    @Override
    public String deleteWarnLevel(Integer id){
        return warnLevelRepository.deleteWarnLevel(id);
    }

    @Override
    public WarnLevelDTO selectWarnLevelByObject(WarnLevelDTO warnLevelDTO){
        return warnLevelRepository.selectWarnLevelByObject(warnLevelDTO);
    }
}
