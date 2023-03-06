package es.tfc.MarcosM.infrastructure.mapper;

import es.tfc.MarcosM.domain.dto.UserDTO;
import es.tfc.MarcosM.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapperInterface{
    UserEntity toEntity(UserDTO userDTO);
    UserDTO toDTO(UserEntity userEntity);
    List<UserEntity> toEntityList(List<UserDTO> userDTOList);
    List<UserDTO> toDTOList(List<UserEntity> userEntityList);
}
