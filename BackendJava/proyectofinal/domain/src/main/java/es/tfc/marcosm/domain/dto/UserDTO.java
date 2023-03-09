package es.tfc.marcosm.domain.dto;

import lombok.Data;

@Data
public class UserDTO {
    public String id;
    public String username;
    public String mail;
    public String password;
}
