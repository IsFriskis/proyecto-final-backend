package es.tfc.marcosm.domain.repository;

import es.tfc.marcosm.domain.dto.GameDTO;

import java.util.List;

public interface GameRepository {
    List<GameDTO> selectAllGames();

    GameDTO selectGameById(Integer id);
}
