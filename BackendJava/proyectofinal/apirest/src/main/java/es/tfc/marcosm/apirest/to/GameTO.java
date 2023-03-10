package es.tfc.marcosm.apirest.to;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GameTO {
    private Integer id;
    private Float score;
    private LocalDateTime date;
    private Integer userId;
}
