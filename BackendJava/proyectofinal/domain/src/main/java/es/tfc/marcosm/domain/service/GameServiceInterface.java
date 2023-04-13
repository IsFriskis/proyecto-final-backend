package es.tfc.marcosm.domain.service;

import es.tfc.marcosm.domain.dto.GameDTO;

import java.util.List;

public interface GameServiceInterface {
    List<GameDTO> selectAllGames();

    GameDTO selectGameById(Integer id);

    GameDTO createGame(GameDTO gameDTO);

    String deleteGame(Integer id);

    GameDTO updateGame(Integer id, GameDTO gameDTO);

    GameDTO selectGameByObject(GameDTO gameDTO);

    Integer selectGamesAmountByUserId(String userId);
}
