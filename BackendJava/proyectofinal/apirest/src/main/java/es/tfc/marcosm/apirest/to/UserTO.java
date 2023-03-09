package es.tfc.marcosm.apirest.to;

import lombok.Data;

@Data
public class UserTO {
    public String id;
    public String username;
    public String mail;
    public String password;
}
