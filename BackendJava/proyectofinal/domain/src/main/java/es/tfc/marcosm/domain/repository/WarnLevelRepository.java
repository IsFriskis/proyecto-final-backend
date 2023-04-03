package es.tfc.marcosm.domain.repository;

import es.tfc.marcosm.domain.dto.WarnLevelDTO;

import java.util.List;

public interface WarnLevelRepository {

    List<WarnLevelDTO> selectAllWarnLevels();

    WarnLevelDTO selectWarnLevelById(Integer id);

    WarnLevelDTO createWarnLevel(WarnLevelDTO warnLevelDTO);

    String deleteWarnLevel(Integer id);

    WarnLevelDTO updateWarnLevel(WarnLevelDTO warnLevelDTO);

    WarnLevelDTO selectWarnLevelByObject(WarnLevelDTO warnLevelDTO);
}
