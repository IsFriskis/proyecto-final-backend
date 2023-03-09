package es.tfc.marcosm.infrastructure.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    public String id;
    public String username;
    public String mail;
    public String password;
}
