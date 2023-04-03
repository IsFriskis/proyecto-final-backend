package es.tfc.marcosm.apirest.mapper;

import es.tfc.marcosm.apirest.to.PermissionTO;
import es.tfc.marcosm.domain.dto.PermissionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapperTO {
    PermissionTO toTO(PermissionDTO permissionDTO);
    PermissionDTO toDTO(PermissionTO permissionTO);
    List<PermissionTO> toTOList(Iterable<PermissionDTO> permissionDTOs);
    List<PermissionDTO> toDTOList(Iterable<PermissionTO> permissionTOs);
}
