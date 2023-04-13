package es.tfc.marcosm.domain.repository;

import es.tfc.marcosm.domain.dto.WarnDTO;

import java.util.List;

public interface WarnRepository {
    List<WarnDTO> selectAllWarns();

    WarnDTO selectWarnById(Integer id);

    WarnDTO createWarn(WarnDTO warnDTO);

    String deleteWarn(Integer id);

    WarnDTO updateWarn(WarnDTO warnDTO);

    WarnDTO selectWarnByObject(WarnDTO warnDTO);

    List<WarnDTO> selectWarnByUserId(String userId);

    Integer selectWarnsAmountByUserId(String userId);
}
