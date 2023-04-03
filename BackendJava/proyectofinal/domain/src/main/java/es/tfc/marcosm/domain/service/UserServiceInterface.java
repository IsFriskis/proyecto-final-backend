package es.tfc.marcosm.domain.service;

import es.tfc.marcosm.domain.dto.UserDTO;

import java.util.List;

public interface UserServiceInterface {
    List<UserDTO> selectAllUsers();

    UserDTO selectUserById(String id);

    UserDTO createUser(UserDTO user);

    UserDTO updateUser(String id, UserDTO userDTO);

    void deleteUser(String id);

    UserDTO selectUserByObject(UserDTO userDTO);
}
