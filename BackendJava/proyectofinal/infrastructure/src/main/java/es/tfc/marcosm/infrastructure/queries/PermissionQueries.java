package es.tfc.marcosm.infrastructure.queries;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = "permissionQueries.properties")
public class PermissionQueries {

    @Value("${selectAllPermissions}")
    private String selectAllPermissions;

    @Value("${selectPermissionById}")
    private String selectPermissionById;

    @Value("${createPermission}")
    private String createPermission;

    @Value("${deletePermission}")
    private String deletePermission;

    @Value("${upgradePermission}")
    private String upgradePermission;

    @Value("${downgradePermission}")
    private String downgradePermission;

    @Value("${selectPermissionByObject}")
    private String selectPermissionByObject;
}
