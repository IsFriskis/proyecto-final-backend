package es.tfc.marcosm.application.servicios;

import es.tfc.marcosm.domain.dto.GameDTO;
import es.tfc.marcosm.domain.repository.GameRepository;
import es.tfc.marcosm.domain.service.GameServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameService implements GameServiceInterface {

    @Autowired
    private final GameRepository gameRepository;

    @Override
    public List<GameDTO> selectAllGames(){
        return gameRepository.selectAllGames();
    }

    @Override
    public GameDTO selectGameById(Integer id){
        return gameRepository.selectGameById(id);
    }

    @Override
    public GameDTO createGame(GameDTO gameDTO){
        return gameRepository.createGame(gameDTO);
    }

    @Override
    public String deleteGame(Integer id){
        return gameRepository.deleteGame(id);
    }

    @Override
    public GameDTO updateGame(Integer id, GameDTO gameDTO){
        gameDTO.setId(id);
        return gameRepository.updateGame(gameDTO);
    }

    @Override
    public GameDTO selectGameByObject(GameDTO gameDTO){
        return gameRepository.selectGameByObject(gameDTO);
    }

}
