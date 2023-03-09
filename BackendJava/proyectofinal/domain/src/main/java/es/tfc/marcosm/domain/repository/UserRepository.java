package es.tfc.marcosm.domain.repository;

import es.tfc.marcosm.domain.dto.UserDTO;

import java.util.List;

public interface UserRepository {

    List<UserDTO> selectAllUsers();
}
