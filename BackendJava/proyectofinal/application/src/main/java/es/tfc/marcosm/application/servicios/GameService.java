package es.tfc.marcosm.application.servicios;

import es.tfc.marcosm.domain.dto.GameDTO;
import es.tfc.marcosm.domain.dto.RankingDTO;
import es.tfc.marcosm.domain.repository.GameRepository;
import es.tfc.marcosm.domain.repository.UserRepository;
import es.tfc.marcosm.domain.service.GameServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GameService implements GameServiceInterface {

    @Autowired
    private final GameRepository gameRepository;

    @Autowired
    private final UserRepository userRepository;

    @Override
    public List<GameDTO> selectAllGames(){
        return gameRepository.selectAllGames();
    }

    @Override
    public List<RankingDTO> rankingGames(){
        List<GameDTO> games = gameRepository.selectAllGames();
        List<RankingDTO> toReturn = new ArrayList<>();

        for (GameDTO game: games) {
            RankingDTO rank = new RankingDTO();
            rank.setUsername(userRepository.selectUserById(game.getUserId()).getUsername());
            rank.setId(game.getId());
            rank.setDate(game.getDate());
            rank.setScore(game.getScore());

            toReturn.add(rank);
        }
        return toReturn;
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

    @Override
    public Integer selectGamesAmountByUserId(String userId){
        return gameRepository.selectGamesAmountByUserId(userId);
    }

}
