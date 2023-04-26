package es.tfc.marcosm.domain.service;

import es.tfc.marcosm.domain.dto.PlayerCardDTO;
import es.tfc.marcosm.domain.dto.UserDTO;

import java.util.List;

public interface UserServiceInterface {
    List<UserDTO> selectAllUsers();

    UserDTO selectUserById(String id);

    UserDTO createUser(UserDTO user);

    UserDTO updateUser(String id, UserDTO userDTO);

    void deleteUser(String id);

    UserDTO selectUserByObject(UserDTO userDTO);

    List<PlayerCardDTO> selectUsersByNameFilter(String id, Integer pageableLimit, Integer offset);

    List<PlayerCardDTO> selectUsersWithPlayerCard();

    UserDTO loginProcess(String email, String password);

    UserDTO registerProcess(String email, String username, String password);

    Integer selectPageableLimit(String username, Integer pageableLimit);
}
