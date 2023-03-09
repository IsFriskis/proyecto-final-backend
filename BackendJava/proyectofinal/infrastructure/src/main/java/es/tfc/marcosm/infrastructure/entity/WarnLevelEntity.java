package es.tfc.marcosm.infrastructure.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarnLevelEntity {
    public Integer id;
    public String name;
    public String description;
}
