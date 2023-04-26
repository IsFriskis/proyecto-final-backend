package es.tfc.marcosm.application.servicios;

import es.tfc.marcosm.domain.dto.PlayerCardDTO;
import es.tfc.marcosm.domain.dto.UserDTO;
import es.tfc.marcosm.domain.repository.GameRepository;
import es.tfc.marcosm.domain.repository.UserRepository;

import es.tfc.marcosm.domain.repository.WarnRepository;
import es.tfc.marcosm.domain.service.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final WarnRepository warnRepository;

    @Autowired
    private final GameRepository gameRepository;

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

    @Override
    public UserDTO selectUserByObject(UserDTO userDTO) {
        return userRepository.selectUserByObject(userDTO);
    }

    @Override
    public List<PlayerCardDTO> selectUsersByNameFilter(String username, Integer pageableLimit, Integer offset){
        List<PlayerCardDTO> toReturn = null;
        List<UserDTO> users = userRepository.selectUsersByNameFilter(username, pageableLimit,offset);
        for (UserDTO user: users) {
            PlayerCardDTO playerCard = new PlayerCardDTO();
            playerCard.setId(user.getId());
            playerCard.setName(user.getUsername());
            playerCard.setGamesPlayed(gameRepository.selectGamesAmountByUserId(user.getId()));
            playerCard.setWarnsApplied(warnRepository.selectWarnsAmountByUserId(user.getId()));
        }

        return toReturn;
    }

    @Override
    public List<PlayerCardDTO> selectUsersWithPlayerCard(){
        List<PlayerCardDTO> toReturn = new ArrayList<>();
        List<UserDTO> users = userRepository.selectAllUsers();
        for (UserDTO user: users) {
            PlayerCardDTO playerCard = new PlayerCardDTO();
            playerCard.setId(user.getId());
            playerCard.setName(user.getUsername());
            playerCard.setGamesPlayed(gameRepository.selectGamesAmountByUserId(user.getId()));
            playerCard.setWarnsApplied(warnRepository.selectWarnsAmountByUserId(user.getId()));
            toReturn.add(playerCard);
        }

        return toReturn;
    }

    @Override
    public UserDTO loginProcess(String email, String password){
        UserDTO user = new UserDTO();
        if(isEmailValid(email) && isPasswordValid(password)){
            try{
                user = userRepository.selectUserByMail(email);
            }catch(EmptyResultDataAccessException e){
                return null;
            }
            if(user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public UserDTO registerProcess(String username, String email, String password){
        UserDTO user = new UserDTO();
        List<UserDTO> listsUsername = new ArrayList<>();
        List<UserDTO> listsMail = new ArrayList<>();
        try{
            listsMail = userRepository.checkIfMailIsValid(email);
            if(listsMail.size() == 0){
                throw new EmptyResultDataAccessException(1);
            } else {
                return null;
            }
        }catch(EmptyResultDataAccessException e){
            user.setMail(email);
        }
        try{
            listsUsername = userRepository.checkIfUsernameIsValid(username);
            if(listsUsername.size() == 0){
                throw new EmptyResultDataAccessException(1);
            } else {
                return null;
            }
        }catch(EmptyResultDataAccessException e){
            user.setUsername(username);
        }
        if(isPasswordValid(password)){
            user.setPassword(password);
        } else{
            return null;
        }
        if(listsUsername.size() == 0 && listsMail.size() == 0 && isPasswordValid(password)){
            userRepository.createUser(user);
            return user;
        } else{
            return null;
        }
    }

    @Override
    public Integer selectPageableLimit(String username, Integer pageableLimit) {
        return userRepository.selectPageableLimit(username, pageableLimit);
    }

    private boolean isEmailValid(String email){
        if(email.contains("@") && email.contains(".")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPasswordValid(String password){
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        for(int i=0;i < password.length();i++) {
            ch = password.charAt(i);
            if( Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag)
                return true;
        }
        return false;
    }


}
