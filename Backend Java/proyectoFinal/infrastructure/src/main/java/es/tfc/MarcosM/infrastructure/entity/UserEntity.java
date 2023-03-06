package es.tfc.MarcosM.infrastructure.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {
    private String id;
    private String username;
    private String mail;
    private String password;
}
