package es.tfc.marcosm.apirest.mapper;

import es.tfc.marcosm.apirest.to.PlayerCardTO;
import es.tfc.marcosm.domain.dto.PlayerCardDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PlayerCardMapperTO {
    PlayerCardDTO toDTO(PlayerCardTO playerCardTO);
    PlayerCardTO toTO(PlayerCardDTO playerCardDTO);
    List<PlayerCardDTO> toDTOList(List<PlayerCardTO> playerCardTOS);
    List<PlayerCardTO> toTOList(List<PlayerCardDTO> playerCardDTOS);
}
