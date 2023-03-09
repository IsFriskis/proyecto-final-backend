package es.tfc.marcosm.apirest.mapper;

import es.tfc.marcosm.apirest.to.WarnLevelTO;
import es.tfc.marcosm.domain.dto.WarnLevelDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WarnLevelMapperTO {
    WarnLevelTO toTo(WarnLevelDTO warnLevelDTO);
    WarnLevelDTO toDTO(WarnLevelTO warnLevelTO);
    List<WarnLevelTO> toTOList(Iterable<WarnLevelDTO> warnLevelDTOs);
    List<WarnLevelDTO> toDTOList(Iterable<WarnLevelTO> warnLevelTOs);
}
