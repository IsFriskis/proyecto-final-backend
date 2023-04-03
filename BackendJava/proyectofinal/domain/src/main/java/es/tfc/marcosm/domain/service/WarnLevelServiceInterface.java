package es.tfc.marcosm.domain.service;

import es.tfc.marcosm.domain.dto.WarnLevelDTO;

import java.util.List;

public interface WarnLevelServiceInterface {
    List<WarnLevelDTO> selectAllWarnLevels();

    WarnLevelDTO selectWarnLevelById(Integer id);

    WarnLevelDTO createWarnLevel(WarnLevelDTO warnLevelDTO);

    WarnLevelDTO updateWarnLevel(Integer id, WarnLevelDTO warnLevelDTO);

    String deleteWarnLevel(Integer id);

    WarnLevelDTO selectWarnLevelByObject(WarnLevelDTO warnLevelDTO);
}
