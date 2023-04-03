package es.tfc.marcosm.domain.service;

import es.tfc.marcosm.domain.dto.WarnDTO;

import java.util.List;

public interface WarnServiceInterface {
    List<WarnDTO> selectAllWarns();

    WarnDTO selectWarnById(Integer id);

    WarnDTO createWarn(WarnDTO warnDTO);

    WarnDTO updateWarn(Integer id, WarnDTO warnDTO);

    String deleteWarn(Integer id);

    WarnDTO selectWarnByObject(WarnDTO warnDTO);
}
