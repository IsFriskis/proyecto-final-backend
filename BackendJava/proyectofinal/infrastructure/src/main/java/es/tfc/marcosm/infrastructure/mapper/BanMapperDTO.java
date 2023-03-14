package es.tfc.marcosm.infrastructure.mapper;

import es.tfc.marcosm.domain.dto.BanDTO;
import es.tfc.marcosm.infrastructure.entity.BanEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BanMapperDTO {
    BanDTO toDTO(BanEntity banEntity);
    BanEntity toEntity(BanDTO banDTO);

    List<BanDTO> toDTOList(Iterable<BanEntity> banEntities);
    List<BanEntity> toEntityList(Iterable<BanDTO> banDTOs);
}
