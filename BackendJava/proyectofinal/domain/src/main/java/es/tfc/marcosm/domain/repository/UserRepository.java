package es.tfc.marcosm.domain.repository;

import es.tfc.marcosm.domain.dto.UserDTO;

import java.util.List;

public interface UserRepository {

    List<UserDTO> selectAllUsers();

    UserDTO selectUserById(String id);

    UserDTO selectUserByMail(String mail);

    UserDTO createUser(UserDTO userDTO);

    String deleteUser(String id);

    UserDTO updateUser(UserDTO userDTO);

    UserDTO selectUserByObject(UserDTO userDTO);

    List<UserDTO> selectUsersByNameFilter(String id, Integer pageableLimit, Integer offset);

    Integer selectPageableLimit(String username, Integer pageableLimit);

    List<UserDTO> checkIfUsernameIsValid(String username);

    List<UserDTO> checkIfMailIsValid(String mail);
}
