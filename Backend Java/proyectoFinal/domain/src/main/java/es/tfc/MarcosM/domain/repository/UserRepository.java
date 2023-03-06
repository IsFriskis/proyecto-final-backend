package es.tfc.MarcosM.domain.repository;

import es.tfc.MarcosM.domain.dto.UserDTO;

public interface UserRepository {

    UserDTO selectAllusers();
}
