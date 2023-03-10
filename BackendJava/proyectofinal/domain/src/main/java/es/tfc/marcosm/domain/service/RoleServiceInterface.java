package es.tfc.marcosm.domain.service;


import es.tfc.marcosm.domain.dto.RoleDTO;

import javax.management.relation.Role;
import java.util.List;

public interface RoleServiceInterface {
    List<RoleDTO> selectAllRoles();

    RoleDTO selectRoleById(Integer id);

    RoleDTO createRole(RoleDTO roleDTO);

    String deleteRole(Integer id);

    RoleDTO updateRole(Integer id, RoleDTO roleDTO);

    RoleDTO selectRolesByObject(RoleDTO roleDTO);
}
