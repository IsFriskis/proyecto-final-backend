package es.tfc.marcosm.apirest.controller;

import es.tfc.marcosm.apirest.mapper.PermissionMapperTO;
import es.tfc.marcosm.apirest.to.PermissionTO;
import es.tfc.marcosm.domain.service.PermissionServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private final PermissionServiceInterface permissionService;

    @Autowired
    private final PermissionMapperTO permissionMapper;

    @GetMapping(value = "/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("PermissionController Up", getHeader(), HttpStatus.OK);
    }
    @GetMapping(value = "/all")
    public List<PermissionTO> selectAllPermissions(){
        return permissionMapper.toTOList(permissionService.selectAllPermissions());
    }

    @GetMapping(value = "/{id}")
    public PermissionTO selectPermissionById(@PathVariable Integer id){
        return permissionMapper.toTO(permissionService.selectPermissionById(id));
    }

    @PostMapping(value = "/create")
    public PermissionTO createPermission(@RequestBody PermissionTO permissionTO){
        return permissionMapper.toTO(permissionService.createPermission(permissionMapper.toDTO(permissionTO)));
    }

    @PutMapping(value = "/upgrade/{id}")
    public PermissionTO upgradePermission(@PathVariable Integer id){
        return permissionMapper.toTO(permissionService.upgradePermission(id));
    }
    @PutMapping(value = "/downgrade/{id}")
    public PermissionTO downgradePermission(@PathVariable Integer id){
        return permissionMapper.toTO(permissionService.downgradePermission(id));
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deletePermission(@PathVariable Integer id){
        return permissionService.deletePermission(id);
    }

    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        headers.add("Access-Control-Allow-Origin"," http://localhost:3000");
        return headers;
    }
}
