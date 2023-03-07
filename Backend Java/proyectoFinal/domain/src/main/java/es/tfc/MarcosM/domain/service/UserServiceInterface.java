package es.tfc.MarcosM.domain.service;

import es.tfc.MarcosM.domain.dto.UserDTO;

import java.util.List;

public interface UserServiceInterface {
    List<UserDTO> selectAllUsers();
}
