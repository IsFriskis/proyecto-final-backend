package es.tfc.MarcosM.domain.repository;

import es.tfc.MarcosM.domain.dto.UserDTO;

import java.util.List;

public interface UserRepository {
    List<UserDTO> selectAllusers();
}
