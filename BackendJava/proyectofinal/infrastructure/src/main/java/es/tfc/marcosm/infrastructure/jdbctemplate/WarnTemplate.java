package es.tfc.marcosm.infrastructure.jdbctemplate;

import es.tfc.marcosm.domain.dto.WarnDTO;
import es.tfc.marcosm.domain.repository.WarnRepository;
import es.tfc.marcosm.infrastructure.mapper.WarnMapperDTO;
import es.tfc.marcosm.infrastructure.queries.WarnQueries;
import es.tfc.marcosm.infrastructure.rowmapper.WarnRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@AllArgsConstructor
public class WarnTemplate implements WarnRepository {

    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private final WarnQueries warnQueries;

    @Autowired
    private final WarnMapperDTO warnMapper;

    @Override
    public List<WarnDTO> selectAllWarns(){
        return warnMapper.toDTOList(namedParameterJdbcTemplate.query(warnQueries.getSelectAllWarns(), new WarnRowMapper()));
    }

    @Override
    public WarnDTO selectWarnById(Integer id){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return warnMapper.toDTO(namedParameterJdbcTemplate.queryForObject(warnQueries.getSelectWarnById(), params,new WarnRowMapper()));
    }

    @Override
    public WarnDTO createWarn(WarnDTO warnDTO){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("title", warnDTO.getTitle());
        params.addValue("description", warnDTO.getDescription());
        params.addValue("warnlevel_id", warnDTO.getWarnLevelId());
        if(warnDTO.getDate() != null){
            warnDTO.setDate(LocalDateTime.now());
        }
        params.addValue("user_id", warnDTO.getUserId());

        namedParameterJdbcTemplate.update(warnQueries.getCreateWarn(), params);

        return selectWarnByObject(warnDTO);
    }

    @Override
    public String deleteWarn(Integer id){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        namedParameterJdbcTemplate.update(warnQueries.getDeleteWarn(), params);

        return "Warn borrado con éxito";
    }

    @Override
    public WarnDTO updateWarn(WarnDTO warnDTO){
        MapSqlParameterSource params = new MapSqlParameterSource();
        WarnDTO warnOriginal = selectWarnById(warnDTO.getId());
        WarnDTO toReturn = new WarnDTO();

        if(warnDTO.getId() != null){
            params.addValue("id", warnDTO.getId());
            toReturn.setId(warnDTO.getId());
        } else{
            params.addValue("id", warnOriginal.getId());
            toReturn.setId(warnOriginal.getId());
        }
        if(warnDTO.getTitle()!= null){
            params.addValue("title", warnDTO.getTitle());
            toReturn.setTitle(warnDTO.getTitle());
        } else{
            params.addValue("title", warnOriginal.getTitle());
            toReturn.setTitle(warnOriginal.getTitle());
        }
        if(warnDTO.getDescription() != null){
            params.addValue("description", warnDTO.getDescription());
            toReturn.setDescription(warnDTO.getDescription());
        } else{
            params.addValue("description", warnOriginal.getDescription());
            toReturn.setDescription(warnOriginal.getDescription());
        }
        if(warnDTO.getWarnLevelId()!= null){
            params.addValue("warnlevel_id", warnDTO.getWarnLevelId());
            toReturn.setWarnLevelId(warnDTO.getWarnLevelId());
        } else{
            params.addValue("warnlevel_id", warnOriginal.getWarnLevelId());
            toReturn.setWarnLevelId(warnOriginal.getWarnLevelId());
        }
        if(warnDTO.getDate()!= null){
            params.addValue("date", warnDTO.getDate());
            toReturn.setDate(warnDTO.getDate());
        }else{
            params.addValue("date", warnOriginal.getDate());
            toReturn.setDate(warnOriginal.getDate());
        }
        if(warnDTO.getUserId()!= null){
            params.addValue("user_id", warnDTO.getUserId());
            toReturn.setUserId(warnDTO.getUserId());
        } else{
            params.addValue("user_id", warnOriginal.getUserId());
            toReturn.setUserId(warnOriginal.getUserId());
        }

        namedParameterJdbcTemplate.update(warnQueries.getUpdateWarn(), params);

        return toReturn;
    }

    @Override
    public WarnDTO selectWarnByObject(WarnDTO warnDTO) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("title", warnDTO.getTitle());
        params.addValue("description", warnDTO.getDescription());
        params.addValue("warnlevel_id", warnDTO.getWarnLevelId());
        params.addValue("user_id", warnDTO.getUserId());

        return warnMapper.toDTO(namedParameterJdbcTemplate.queryForObject(warnQueries.getSelectWarnByObject(), params, new WarnRowMapper()));
    }
}
