package es.tfc.marcosm.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GameDTO {
    private Integer id;
    private Float score;
    private LocalDateTime date;
    private Integer userId;
}
