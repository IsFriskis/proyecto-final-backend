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

    }
}
