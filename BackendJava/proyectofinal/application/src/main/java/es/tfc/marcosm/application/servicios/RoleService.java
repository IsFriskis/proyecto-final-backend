package es.tfc.marcosm.application.servicios;

import es.tfc.marcosm.domain.dto.RoleDTO;
import es.tfc.marcosm.domain.repository.RoleRepository;
import es.tfc.marcosm.domain.service.RoleServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService implements RoleServiceInterface {

    @Autowired
    private final RoleRepository roleRepository;

    @Override
    public List<RoleDTO> selectAllRoles(){
        return roleRepository.selectAllRoles();
    }

    @Override
    public RoleDTO selectRoleById(Integer id){
        return roleRepository.selectRoleById(id);
    }

    @Override
    public RoleDTO createRole(RoleDTO roleDTO){
        return roleRepository.createRole(roleDTO);
    }
    @Override
    public String deleteRole(Integer id){
        return roleRepository.deleteRole(id);
    }

    @Override
    public RoleDTO updateRole(Integer id, RoleDTO roleDTO){
        roleDTO.setId(id);
        return roleRepository.updateRole(roleDTO);
    }

    @Override
    public RoleDTO selectRolesByObject(RoleDTO roleDTO){
        return roleRepository.selectRoleByObject(roleDTO);
    }

}
