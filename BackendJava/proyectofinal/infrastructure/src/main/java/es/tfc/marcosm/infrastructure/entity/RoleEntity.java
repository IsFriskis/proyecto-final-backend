package es.tfc.marcosm.infrastructure.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity {
    public Integer id;
    public String name;
    public String description;
}
