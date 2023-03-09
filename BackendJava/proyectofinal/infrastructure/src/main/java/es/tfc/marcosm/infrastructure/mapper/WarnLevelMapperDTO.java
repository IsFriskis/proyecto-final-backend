package es.tfc.marcosm.infrastructure.mapper;

import es.tfc.marcosm.domain.dto.WarnLevelDTO;
import es.tfc.marcosm.infrastructure.entity.WarnLevelEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WarnLevelMapperDTO {
    WarnLevelDTO toDTO(WarnLevelEntity warnLevel);
    WarnLevelEntity toEntity(WarnLevelDTO warnLevelDTO);

    List<WarnLevelDTO> toDTOList(Iterable<WarnLevelEntity> warnLevels);

    List<WarnLevelEntity> toEntityList(Iterable<WarnLevelDTO> warnLevels);
}
