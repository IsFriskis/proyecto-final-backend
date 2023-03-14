package es.tfc.marcosm.infrastructure.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BanEntity {
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime timestart;
    private LocalDateTime timeend;
    private Boolean review;
    private String userId;
}
