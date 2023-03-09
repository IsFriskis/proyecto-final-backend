package es.tfc.marcosm.apirest.mapper;

import es.tfc.marcosm.apirest.to.UserTO;
import es.tfc.marcosm.domain.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapperTO {
    UserTO toTO(UserDTO userDTO);
    UserDTO toDTO(UserTO userTO);
    List<UserTO> toTOList(Iterable<UserDTO> userDTOs);
    List<UserDTO> toDTOList(Iterable<UserTO> userTOs);
}
