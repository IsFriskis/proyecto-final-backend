package es.tfc.marcosm.infrastructure.mapper;

import es.tfc.marcosm.domain.dto.PermissionDTO;
import es.tfc.marcosm.infrastructure.entity.PermissionEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapperDTO {
    PermissionDTO toDTO(PermissionEntity permissionEntity);
    PermissionEntity toEntity(PermissionDTO permissionDTO);
    List<PermissionDTO> toDTOList(Iterable<PermissionEntity> permissionEntities);
    List<PermissionEntity> toEntityList(Iterable<PermissionDTO> permissionDTOs);
}
