package es.tfc.marcosm.infrastructure.jdbctemplate;

import es.tfc.marcosm.domain.dto.GameDTO;
import es.tfc.marcosm.domain.repository.GameRepository;
import es.tfc.marcosm.infrastructure.mapper.GameMapperDTO;
import es.tfc.marcosm.infrastructure.queries.GameQueries;
import es.tfc.marcosm.infrastructure.rowmapper.GameRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@AllArgsConstructor
public class GameTemplate implements GameRepository {

    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private final GameQueries gameQueries;

    @Autowired
    private final GameMapperDTO gameMapper;

    @Override
    public List<GameDTO> selectAllGames(){
        return gameMapper.toDTOList( namedParameterJdbcTemplate.query(gameQueries.getSelectAllGames(), new GameRowMapper()));
    }

    @Override
    public GameDTO selectGameById(Integer id){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return gameMapper.toDTO(namedParameterJdbcTemplate.queryForObject(gameQueries.getSelectGameById(), params, new GameRowMapper()));
    }
    @Override
    public GameDTO createGame(GameDTO gameDTO){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("score", gameDTO.getScore());
        if(gameDTO.getDate() == null){
            gameDTO.setDate(LocalDateTime.now());
        }
        params.addValue("user_id", gameDTO.getUserId());
        namedParameterJdbcTemplate.update(gameQueries.getCreateGame(), params);

        return selectGameByObject(gameDTO);
    }

    @Override
    public String deleteGame(Integer id){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        namedParameterJdbcTemplate.update(gameQueries.getDeleteGame(), params);

        return "Game borrado con éxito";
    }

    @Override
    public GameDTO updateGame(GameDTO gameDTO){

        MapSqlParameterSource params = new MapSqlParameterSource();
        GameDTO gameOriginal = selectGameById((gameDTO.getId()));
        GameDTO toReturn = new GameDTO();
        if(gameDTO.getId() != null){
            params.addValue("id", gameDTO.getId());
            toReturn.setId(gameDTO.getId());
        }else {
            params.addValue("id", gameOriginal.getId());
            toReturn.setId(gameOriginal.getId());
        }
        if(gameDTO.getScore() != null){
            params.addValue("score", gameDTO.getScore());
            toReturn.setScore(gameDTO.getScore());
        } else{
            params.addValue("score", gameOriginal.getScore());
            toReturn.setScore(gameOriginal.getScore());
        }

        if(gameDTO.getDate() != null){
            params.addValue("date", gameDTO.getDate());
            toReturn.setDate(gameDTO.getDate());
        }else{
            params.addValue("date", gameOriginal.getDate());
            toReturn.setDate(gameOriginal.getDate());
        }
        if (gameDTO.getUserId() != null) {
            params.addValue("user_id", gameDTO.getUserId());
            toReturn.setUserId(gameDTO.getUserId());
        }else {
            params.addValue("user_id",   gameOriginal.getUserId());
            toReturn.setUserId(gameOriginal.getUserId());
        }

        namedParameterJdbcTemplate.update(gameQueries.getUpdateGame(),params);

        return toReturn;
    }

    @Override
    public GameDTO selectGameByObject(GameDTO gameDTO){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("score", gameDTO.getScore());
        params.addValue("user_id", gameDTO.getUserId());

        return gameMapper.toDTO(namedParameterJdbcTemplate.queryForObject(gameQueries.getSelectGameByObject(), params, new GameRowMapper()));
    }
}
