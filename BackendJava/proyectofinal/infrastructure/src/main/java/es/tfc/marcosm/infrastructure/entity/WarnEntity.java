package es.tfc.marcosm.infrastructure.entity;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarnEntity {
    private Integer id;
    private String title;
    private String description;
    private Integer warnLevelId;
    private LocalDateTime date;
    private String userId;
}
