package es.tfc.marcosm.infrastructure.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameEntity {
    private Integer id;
    private Float score;
    private LocalDateTime date;
    private String userId;
}
