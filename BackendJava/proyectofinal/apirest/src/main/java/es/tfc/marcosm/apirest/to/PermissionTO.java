package es.tfc.marcosm.apirest.to;

import lombok.Data;

@Data
public class PermissionTO {
    private Integer id;
    private Integer roleId;
    private String userId;
}
