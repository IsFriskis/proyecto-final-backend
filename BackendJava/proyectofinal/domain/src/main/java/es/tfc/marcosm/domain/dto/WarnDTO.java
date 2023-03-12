package es.tfc.marcosm.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WarnDTO {
    private Integer id;
    private String title;
    private String description;
    private Integer warnLevelId;
    private LocalDateTime date;
    private String userId;
}
