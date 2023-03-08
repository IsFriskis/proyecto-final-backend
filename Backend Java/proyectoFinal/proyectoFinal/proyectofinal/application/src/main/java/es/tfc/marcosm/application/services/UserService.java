package es.tfc.marcosm.application.services;

import es.tfc.MarcosM.domain.dto.UserDTO;
import es.tfc.MarcosM.domain.repository.UserRepository;
import es.tfc.MarcosM.domain.service.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

    /*@Autowired
    private final UserRepository userRepository;*/

    @Override
    public List<UserDTO> selectAllUsers() {
        return null;
    }

    @Override
    public String capas() {
        return "Llegué hasta application";
    }
}
