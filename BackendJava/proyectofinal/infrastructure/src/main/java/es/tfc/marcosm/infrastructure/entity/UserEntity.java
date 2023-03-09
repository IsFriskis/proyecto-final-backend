package es.tfc.marcosm.infrastructure.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    private String id;
    private String username;
    private String mail;
    private String password;
}
