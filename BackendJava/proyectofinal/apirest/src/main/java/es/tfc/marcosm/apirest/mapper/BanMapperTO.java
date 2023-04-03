package es.tfc.marcosm.apirest.mapper;

import es.tfc.marcosm.apirest.to.BanTO;
import es.tfc.marcosm.domain.dto.BanDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BanMapperTO {
    BanTO toTO(BanDTO banDTO);
    BanDTO toDTO(BanTO banTO);

    List<BanTO> toTOList(Iterable<BanDTO> banDTOs);
    List<BanDTO> toDTOList(Iterable<BanTO> banTOs);
}
