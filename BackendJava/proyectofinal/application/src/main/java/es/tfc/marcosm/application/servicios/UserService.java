package es.tfc.marcosm.application.servicios;

import es.tfc.marcosm.domain.dto.UserDTO;
import es.tfc.marcosm.domain.repository.UserRepository;
import es.tfc.marcosm.domain.service.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

    @Autowired
    private final UserRepository userRepository;
    @Override
    public List<UserDTO> selectAllUsers() {
        return userRepository.selectAllUsers();
    }

    @Override
    public UserDTO selectUserById(String id) {
        return userRepository.selectUserById(id);
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        return userRepository.createUser(user);
    }

    @Override
    public UserDTO updateUser(String id, UserDTO userDTO) {
        userDTO.setId(id);
        return userRepository.updateUser(userDTO);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteUser(id);
    }
}
