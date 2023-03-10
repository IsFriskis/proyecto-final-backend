package es.tfc.marcosm.apirest.controller;

import es.tfc.marcosm.apirest.mapper.RoleMapperTO;
import es.tfc.marcosm.apirest.to.RoleTO;
import es.tfc.marcosm.domain.service.RoleServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private final RoleServiceInterface roleService;

    @Autowired
    private final RoleMapperTO roleMapper;

    @GetMapping(value = "/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("RoleController Up", getHeader(), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<RoleTO> selectAllRoles() {
        return roleMapper.toTOList(roleService.selectAllRoles());
    }

    @GetMapping(value = "/{id}")
    public RoleTO selectRoleById(@PathVariable("id") Integer id) {
        return roleMapper.toTO(roleService.selectRoleById(id));
    }

    @PostMapping(value = "/create")
    public RoleTO createRole(@RequestBody RoleTO roleTO) {
        return roleMapper.toTO(roleService.createRole(roleMapper.toDTO(roleTO)));
    }

    @PutMapping(value = "/update/{id}")
    public RoleTO updateRole(@PathVariable Integer id, @RequestBody RoleTO roleTO) {
        return roleMapper.toTO(roleService.updateRole(id, roleMapper.toDTO(roleTO)));
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteRole(@PathVariable Integer id) {
        return roleService.deleteRole(id);
    }


    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        return headers;
    }
}
