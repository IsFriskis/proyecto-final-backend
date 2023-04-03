package es.tfc.marcosm.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BanDTO {
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime timestart;
    private LocalDateTime timeend;
    private Boolean review;
    private String userId;
}
