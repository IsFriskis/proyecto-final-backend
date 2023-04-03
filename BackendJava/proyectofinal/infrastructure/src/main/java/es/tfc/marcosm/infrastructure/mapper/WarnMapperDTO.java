package es.tfc.marcosm.infrastructure.mapper;

import es.tfc.marcosm.domain.dto.WarnDTO;
import es.tfc.marcosm.infrastructure.entity.WarnEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WarnMapperDTO {
    WarnDTO toDTO(WarnEntity warnEntity);
    WarnEntity toEntity(WarnDTO warnDTO);
    List<WarnDTO> toDTOList(Iterable<WarnEntity> warnEntities);
    List<WarnEntity> toEntityList(Iterable<WarnDTO> warnDTOs);
}
