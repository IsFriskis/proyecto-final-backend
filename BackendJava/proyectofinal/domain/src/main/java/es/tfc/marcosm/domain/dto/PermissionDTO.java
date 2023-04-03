package es.tfc.marcosm.domain.dto;

import lombok.Data;

@Data
public class PermissionDTO {
    private Integer id;
    private Integer roleId;
    private String userId;
}
