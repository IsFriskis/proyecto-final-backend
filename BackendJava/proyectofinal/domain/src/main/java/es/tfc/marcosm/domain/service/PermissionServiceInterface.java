package es.tfc.marcosm.domain.service;

import es.tfc.marcosm.domain.dto.PermissionDTO;

import java.util.List;

public interface PermissionServiceInterface {
    List<PermissionDTO> selectAllPermissions();

    PermissionDTO selectPermissionById(Integer id);

    PermissionDTO createPermission(PermissionDTO permissionDTO);

    PermissionDTO upgradePermission(Integer id);

    PermissionDTO downgradePermission(Integer id);

    String deletePermission(Integer id);

    PermissionDTO selectPermissionByObject(PermissionDTO permissionDTO);
}
