package es.tfc.marcosm.apirest.mapper;

import es.tfc.marcosm.apirest.to.GameTO;
import es.tfc.marcosm.domain.dto.GameDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GameMapperTO {
    GameTO toTO(GameDTO gameDTO);
    GameDTO toDTO(GameTO gameTO);
    List<GameTO> toTOList(Iterable<GameDTO> gameDTOs);
    List<GameDTO> toDTOList(Iterable<GameTO> gameTOs);
}
