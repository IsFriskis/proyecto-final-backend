package es.tfc.marcosm.apirest.to;

import lombok.Data;

@Data
public class PlayerCardTO {
    private String id;
    private String name;
    private Integer gamesPlayed;
    private Integer warnsApplied;
}
