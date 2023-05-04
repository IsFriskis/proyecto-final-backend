package es.tfc.marcosm.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RankingDTO {
    private Integer id;
    private Float score;
    private LocalDateTime date;
    private String username;
}
