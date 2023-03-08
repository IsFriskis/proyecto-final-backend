package es.tfc.MarcosM.domain.dto;


import lombok.*;

import java.util.List;

@Data
public class UserDTO {
    private String id;
    private String username;
    private String mail;
    private String password;
}
