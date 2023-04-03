package es.tfc.marcosm.domain.repository;

import es.tfc.marcosm.domain.dto.PermissionDTO;

import java.util.List;

public interface PermissionRepository {
    List<PermissionDTO> selectAllPermissions();

    PermissionDTO selectPermissionById(Integer id);

    PermissionDTO createPermission(PermissionDTO permissionDTO);

    PermissionDTO upgradePermission(Integer id);

    PermissionDTO downgradePermission(Integer id);

    String deletePermission(Integer id);

    PermissionDTO selectPermissionByObject(PermissionDTO permissionDTO);
}
