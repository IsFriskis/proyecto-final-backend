package es.tfc.marcosm.domain.repository;

import es.tfc.marcosm.domain.dto.UserDTO;

import java.util.List;

public interface UserRepository {

    List<UserDTO> selectAllUsers();

    UserDTO selectUserById(String id);

    UserDTO createUser(UserDTO userDTO);

    String deleteUser(String id);

    UserDTO updateUser(UserDTO userDTO);
}
