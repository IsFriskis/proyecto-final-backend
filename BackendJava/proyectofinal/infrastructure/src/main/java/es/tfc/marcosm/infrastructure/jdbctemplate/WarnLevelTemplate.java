package es.tfc.marcosm.infrastructure.jdbctemplate;

import es.tfc.marcosm.domain.dto.WarnLevelDTO;
import es.tfc.marcosm.domain.repository.WarnLevelRepository;
import es.tfc.marcosm.infrastructure.mapper.WarnLevelMapperDTO;
import es.tfc.marcosm.infrastructure.queries.WarnLevelQueries;
import es.tfc.marcosm.infrastructure.rowmapper.WarnLevelRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class WarnLevelTemplate implements WarnLevelRepository {

    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private final WarnLevelQueries warnLevelQueries;

    @Autowired
    private final WarnLevelMapperDTO warnLevelMapperDTO;

    @Override
    public List<WarnLevelDTO> selectAllWarnLevels() {
        return warnLevelMapperDTO.toDTOList(namedParameterJdbcTemplate.query(warnLevelQueries.getSelectAllWarnLevels(), new WarnLevelRowMapper()));
    }

    @Override
    public WarnLevelDTO selectWarnLevelById(Integer id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return warnLevelMapperDTO.toDTO(namedParameterJdbcTemplate.queryForObject(warnLevelQueries.getSelectWarnLevelById(), params, new WarnLevelRowMapper()));
    }

    @Override
    public WarnLevelDTO createWarnLevel(WarnLevelDTO warnLevelDTO) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", warnLevelDTO.getName());
        params.addValue("description", warnLevelDTO.getDescription());

        namedParameterJdbcTemplate.update(warnLevelQueries.getCreateWarnLevel(), params);

        return selectWarnLevelByObject(warnLevelDTO);
    }

    @Override
    public String deleteWarnLevel(Integer id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        namedParameterJdbcTemplate.update(warnLevelQueries.getDeleteWarnLevel(), params);

        return "WarnLevel borrado con éxito";
    }

    @Override
    public WarnLevelDTO updateWarnLevel(WarnLevelDTO warnLevelDTO) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        WarnLevelDTO warnLevelOriginal = selectWarnLevelById(warnLevelDTO.getId());
        WarnLevelDTO toReturn = new WarnLevelDTO();
        if(warnLevelDTO.getName() != null){
            params.addValue("name", warnLevelDTO.getName());
            toReturn.setName(warnLevelDTO.getName());
        }else{
            params.addValue("name", warnLevelOriginal.getName());
            toReturn.setName(warnLevelOriginal.getName());
        }

        if(warnLevelDTO.getDescription()!= null){
            params.addValue("description", warnLevelDTO.getDescription());
            toReturn.setDescription(warnLevelDTO.getDescription());
        } else{
            params.addValue("description", warnLevelOriginal.getDescription());
            toReturn.setDescription(warnLevelOriginal.getDescription());
        }

        if(warnLevelDTO.getDescription()!= null){
            params.addValue("description", warnLevelDTO.getDescription());
            toReturn.setDescription(warnLevelDTO.getDescription());
        }else{
            params.addValue("description", warnLevelOriginal.getDescription());
            toReturn.setDescription(warnLevelOriginal.getDescription());
        }

        namedParameterJdbcTemplate.update(warnLevelQueries.getUpdateWarnLevel(), params);

        return selectWarnLevelById(warnLevelDTO.getId());
    }

    @Override
    public WarnLevelDTO selectWarnLevelByObject(WarnLevelDTO warnLevelDTO){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", warnLevelDTO.getName());
        params.addValue("description", warnLevelDTO.getDescription());

        return warnLevelMapperDTO.toDTO(namedParameterJdbcTemplate.queryForObject(warnLevelQueries.getSelectWarnLevelByObject(), params, new WarnLevelRowMapper()));
    }
}
