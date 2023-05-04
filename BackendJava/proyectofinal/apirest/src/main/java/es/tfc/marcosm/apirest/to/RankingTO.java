package es.tfc.marcosm.apirest.to;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RankingTO {
    private Integer id;
    private Float score;
    private LocalDateTime date;
    private String username;
}
