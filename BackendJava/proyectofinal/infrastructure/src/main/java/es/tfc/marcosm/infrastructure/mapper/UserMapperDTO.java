package es.tfc.marcosm.infrastructure.mapper;

import es.tfc.marcosm.domain.dto.UserDTO;
import es.tfc.marcosm.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapperDTO {
    UserDTO toDTO(UserEntity user);
    UserEntity toEntity(UserDTO userDTO);

    List<UserDTO> toDTOList(Iterable<UserEntity> user);

    List<UserEntity> toEntityList(Iterable<UserDTO> userDTO);

}
