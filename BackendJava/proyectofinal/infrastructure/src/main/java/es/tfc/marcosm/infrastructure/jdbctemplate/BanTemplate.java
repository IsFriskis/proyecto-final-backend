package es.tfc.marcosm.infrastructure.jdbctemplate;

import es.tfc.marcosm.domain.dto.BanDTO;
import es.tfc.marcosm.domain.repository.BanRepository;
import es.tfc.marcosm.infrastructure.mapper.BanMapperDTO;
import es.tfc.marcosm.infrastructure.queries.BanQueries;
import es.tfc.marcosm.infrastructure.rowmapper.BanRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BanTemplate implements BanRepository {

    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private final BanMapperDTO banMapper;

    @Autowired
    private final BanQueries banQueries;

    @Override
    public List<BanDTO> selectAllBans(){
        return banMapper.toDTOList(namedParameterJdbcTemplate.query(banQueries.getSelectAllBans() , new BanRowMapper()));
    }

    @Override
    public BanDTO selectBanById(Integer id){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return banMapper.toDTO(namedParameterJdbcTemplate.queryForObject(banQueries.getSelectBanById(), params, new BanRowMapper()));
    }
    @Override
    public BanDTO createBan(BanDTO banDTO){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("title", banDTO.getTitle());
        params.addValue("description", banDTO.getDescription());
        params.addValue("user_id", banDTO.getUserId());

        namedParameterJdbcTemplate.update(banQueries.getCreateBan(), params);

        return selectBanByObject(banDTO);
    }

    @Override
    public String closeBan(Integer id){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        namedParameterJdbcTemplate.update(banQueries.getCloseBan(), params);
        return "Ban con id: " + id + " cerrado";
    }

    @Override
    public BanDTO updateBan(BanDTO banDTO){
        MapSqlParameterSource params = new MapSqlParameterSource();
        BanDTO banOriginal = selectBanById(banDTO.getId());
        BanDTO toReturn = new BanDTO();
        if(banDTO.getTitle()!= null){
            params.addValue("title", banDTO.getTitle());
            toReturn.setTitle(banDTO.getTitle());
        }else{
            params.addValue("title", banOriginal.getTitle());
            toReturn.setTitle(banOriginal.getTitle());
        }
        if(banDTO.getDescription()!= null){
            params.addValue("description", banDTO.getDescription());
            toReturn.setDescription(banDTO.getDescription());
        }else{
            params.addValue("description", banOriginal.getDescription());
            toReturn.setDescription(banOriginal.getDescription());
        }
        if(banDTO.getTimestart()!= null){
            params.addValue("timestart", banDTO.getTimestart());
            toReturn.setTimestart(banDTO.getTimestart());
        }else{
            params.addValue("timestart", banOriginal.getTimestart());
            toReturn.setTimestart(banOriginal.getTimestart());
        }
        if(banDTO.getTimeend() != null){
            params.addValue("timeend", banDTO.getTimeend());
            toReturn.setTimeend(banDTO.getTimeend());
        }else{
            params.addValue("timeend", banOriginal.getTimeend());
            toReturn.setTimeend(banOriginal.getTimeend());
        }
        if(banDTO.getReview()!= null){
            params.addValue("review", banDTO.getReview());
            toReturn.setReview(banDTO.getReview());
        }else{
            params.addValue("review", banOriginal.getReview());
            toReturn.setReview(banOriginal.getReview());
        }
        if(banDTO.getUserId()!= null){
            params.addValue("user_id", banDTO.getUserId());
            toReturn.setUserId(banDTO.getUserId());
        }else{
            params.addValue("user_id", banOriginal.getUserId());
            toReturn.setUserId(banOriginal.getUserId());
        }

        namedParameterJdbcTemplate.update(banQueries.getUpdateBan(), params);
        return banMapper.toDTO(namedParameterJdbcTemplate.queryForObject(banQueries.getSelectBanById(), params, new BanRowMapper()));
    }

    @Override
    public String deleteBan(Integer id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        namedParameterJdbcTemplate.update(banQueries.getDeleteBan(), params);
        return "Ban con id: " + id + " eliminado";
    }

    @Override
    public BanDTO selectBanByObject(BanDTO banDTO) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("title", banDTO.getTitle());
        params.addValue("description", banDTO.getDescription());
        params.addValue("user_id", banDTO.getUserId());

        return banMapper.toDTO(namedParameterJdbcTemplate.queryForObject(banQueries.getSelectBanByObject(), params, new BanRowMapper()));
    }
}
