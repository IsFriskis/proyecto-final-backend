package es.tfc.marcosm.apirest.mapper;

import es.tfc.marcosm.apirest.to.RoleTO;
import es.tfc.marcosm.domain.dto.RoleDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RoleMapperTO {
    RoleTO toTO(RoleDTO rolDTO);
    RoleDTO toDTO(RoleTO rolTO);

    List<RoleTO> toTOList(Iterable<RoleDTO> rolDTOs);
    List<RoleDTO> toDTOList(Iterable<RoleTO> rolTOs);
}
