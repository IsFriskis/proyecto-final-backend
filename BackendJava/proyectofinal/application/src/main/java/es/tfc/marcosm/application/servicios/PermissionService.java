package es.tfc.marcosm.application.servicios;

import es.tfc.marcosm.domain.dto.PermissionDTO;
import es.tfc.marcosm.domain.repository.PermissionRepository;
import es.tfc.marcosm.domain.service.PermissionServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PermissionService implements PermissionServiceInterface {
    @Autowired
    private final PermissionRepository permissionRepository;

    @Override
    public List<PermissionDTO> selectAllPermissions(){
        return permissionRepository.selectAllPermissions();
    }
    @Override
    public PermissionDTO selectPermissionById(Integer id){
        return permissionRepository.selectPermissionById(id);
    }

    @Override
    public PermissionDTO createPermission(PermissionDTO permissionDTO){
        return permissionRepository.createPermission(permissionDTO);
    }

    @Override
    public PermissionDTO upgradePermission(Integer id){
        return permissionRepository.upgradePermission(id);
    }

    @Override
    public PermissionDTO downgradePermission(Integer id){
        return permissionRepository.downgradePermission(id);
    }

    @Override
    public String deletePermission(Integer id){
        return permissionRepository.deletePermission(id);
    }

    @Override
    public PermissionDTO selectPermissionByObject(PermissionDTO permissionDTO){
        return permissionRepository.selectPermissionByObject(permissionDTO);

    }

}
