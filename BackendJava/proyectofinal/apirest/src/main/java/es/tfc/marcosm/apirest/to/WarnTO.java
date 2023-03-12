package es.tfc.marcosm.apirest.to;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WarnTO {
    private Integer id;
    private String title;
    private String description;
    private Integer warnLevelId;
    private LocalDateTime date;
    private String userId;
}
