package es.tfc.marcosm.infrastructure.queries;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = "roleQueries.properties")
public class RoleQueries {

    @Value("${selectAllRoles}")
    private String selectAllRoles;

    @Value("${selectRoleById}")
    private String selectRoleById;

    @Value("${createRole}")
    private String createRole;

    @Value("${updateRole}")
    private String updateRole;

    @Value("${deleteRole}")
    private String deleteRole;

    @Value("${selectRoleByObject}")
    private String selectRoleByObject;


}
