package es.tfc.marcosm.domain.repository;

import es.tfc.marcosm.domain.dto.RoleDTO;

import java.util.List;

public interface RoleRepository {

    List<RoleDTO> selectAllRoles();

    RoleDTO selectRoleById(Integer id);

    RoleDTO createRole(RoleDTO roleDTO);

    String deleteRole(Integer id);

    RoleDTO updateRole(RoleDTO roleDTO);

    RoleDTO selectRoleByObject(RoleDTO roleDTO);
}
