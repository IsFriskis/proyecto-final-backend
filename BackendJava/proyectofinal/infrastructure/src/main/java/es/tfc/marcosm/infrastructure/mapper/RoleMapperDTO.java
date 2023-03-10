package es.tfc.marcosm.infrastructure.mapper;

import es.tfc.marcosm.domain.dto.RoleDTO;
import es.tfc.marcosm.infrastructure.entity.RoleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RoleMapperDTO {
    RoleDTO toDTO(RoleEntity roleEntity);
    RoleEntity toEntity(RoleDTO roleDTO);

    List<RoleDTO> toDTOList(Iterable<RoleEntity> roleEntitys);
    List<RoleEntity> toEntityList(Iterable<RoleDTO> roleDTOs);
}
