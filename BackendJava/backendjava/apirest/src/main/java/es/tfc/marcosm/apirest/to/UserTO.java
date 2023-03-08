package es.tfc.marcosm.apirest.to;

import lombok.Data;

@Data
public class UserTO {
    private String id;
    private String username;
    private String mail;
    private String password;
}
