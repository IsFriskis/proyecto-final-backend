package es.tfc.marcosm.domain.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String username;
    private String mail;
    private String password;
}
