package es.tfc.marcosm.domain.service;



import es.tfc.marcosm.domain.dto.UserDTO;

import java.util.List;

public interface UserServiceInterface {
    List<UserDTO> selectAllUsers();
    String capas();
}
