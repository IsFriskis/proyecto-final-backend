package es.tfc.marcosm.apirest.mapper;

import es.tfc.marcosm.apirest.to.WarnTO;
import es.tfc.marcosm.domain.dto.WarnDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WarnMapperTO {
    WarnDTO toDTO(WarnTO warnTO);
    WarnTO toTO(WarnDTO warnDTO);
    List<WarnDTO> toDTOList(Iterable<WarnTO> warnTOs);
    List<WarnTO> toTOList(Iterable<WarnDTO> warnDTOs);
}
