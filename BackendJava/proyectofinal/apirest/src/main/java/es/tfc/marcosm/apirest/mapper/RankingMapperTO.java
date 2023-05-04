package es.tfc.marcosm.apirest.mapper;

import es.tfc.marcosm.apirest.to.RankingTO;
import es.tfc.marcosm.domain.dto.RankingDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RankingMapperTO {
    RankingDTO toDTO(RankingTO rankingTO);
    RankingTO toTO(RankingDTO rankingDTO);

    List<RankingDTO> toDTOList(List<RankingDTO> rankingDTOList);
    List<RankingTO> toTOList(List<RankingDTO> rankingDTOList);
}
