package es.tfc.marcosm.application.services;


import es.tfc.marcosm.domain.dto.UserDTO;
import es.tfc.marcosm.domain.service.UserServiceInterface;
import lombok.AllArgsConstructor;
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
