package es.tfc.marcosm.domain.repository;

import es.tfc.marcosm.domain.dto.GameDTO;

import java.util.List;

public interface GameRepository {
    List<GameDTO> selectAllGames();

    GameDTO selectGameById(Integer id);

    GameDTO createGame(GameDTO gameDTO);

    String deleteGame(Integer id);

    GameDTO updateGame(GameDTO gameDTO);

    GameDTO selectGameByObject(GameDTO gameDTO);

    Integer selectGamesAmountByUserId(String userId);
}
