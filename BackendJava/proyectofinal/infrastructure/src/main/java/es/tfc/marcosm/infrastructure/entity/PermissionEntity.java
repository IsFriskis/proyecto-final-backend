package es.tfc.marcosm.infrastructure.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PermissionEntity {
    private Integer id;
    private Integer roleId;
    private String userId;
}
