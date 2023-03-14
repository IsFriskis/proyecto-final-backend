package es.tfc.marcosm.apirest.to;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BanTO {
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime timestart;
    private LocalDateTime timeend;
    private Boolean review;
    private String userId;
}
