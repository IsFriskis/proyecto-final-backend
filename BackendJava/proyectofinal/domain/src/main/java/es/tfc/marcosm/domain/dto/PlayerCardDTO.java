package es.tfc.marcosm.domain.dto;

import lombok.Data;

@Data
public class PlayerCardDTO {
    private String id;
    private String name;
    private Integer gamesPlayed;
    private Integer warnsApplied;
}
