package es.tfc.marcosm.infrastructure.mapper;

import es.tfc.marcosm.domain.dto.GameDTO;
import es.tfc.marcosm.infrastructure.entity.GameEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GameMapperDTO {
    GameDTO toDTO(GameEntity gameEntity);
    GameEntity toEntity(GameDTO gameDTO);
    List<GameDTO> toDTOList(Iterable<GameEntity> gameEntities);
    List<GameEntity> toEntityList(Iterable<GameDTO> gameDTOs);
}
