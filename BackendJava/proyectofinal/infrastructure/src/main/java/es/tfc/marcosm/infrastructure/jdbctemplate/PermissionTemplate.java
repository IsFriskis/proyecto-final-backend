package es.tfc.marcosm.infrastructure.jdbctemplate;

import es.tfc.marcosm.domain.dto.PermissionDTO;
import es.tfc.marcosm.domain.repository.PermissionRepository;
import es.tfc.marcosm.infrastructure.mapper.PermissionMapperDTO;
import es.tfc.marcosm.infrastructure.queries.PermissionQueries;
import es.tfc.marcosm.infrastructure.rowmapper.PermissionRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PermissionTemplate implements PermissionRepository {

    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private final PermissionQueries permissionQueries;

    @Autowired
    private final PermissionMapperDTO permissionMapper;

    @Override
    public List<PermissionDTO> selectAllPermissions() {
        return permissionMapper.toDTOList(namedParameterJdbcTemplate.query(permissionQueries.getSelectAllPermissions(), new PermissionRowMapper()));
    }

    @Override
    public PermissionDTO selectPermissionById(Integer id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return permissionMapper.toDTO(namedParameterJdbcTemplate.queryForObject(permissionQueries.getSelectPermissionById(), params, new PermissionRowMapper()));
    }

    @Override
    public PermissionDTO createPermission(PermissionDTO permissionDTO) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("role_id", permissionDTO.getRoleId());
        params.addValue("user_id", permissionDTO.getUserId());
        namedParameterJdbcTemplate.update(permissionQueries.getCreatePermission(), params);
        return selectPermissionByObject(permissionDTO);
    }

    @Override
    public PermissionDTO upgradePermission(Integer id){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        params.addValue("role_id",selectPermissionById(id).getRoleId());
        namedParameterJdbcTemplate.update(permissionQueries.getUpgradePermission(), params);
        return selectPermissionById(id);
    }

    @Override
    public PermissionDTO downgradePermission(Integer id){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        params.addValue("role_id",selectPermissionById(id).getRoleId());
        namedParameterJdbcTemplate.update(permissionQueries.getDowngradePermission(), params);
        return selectPermissionById(id);
    }

    @Override
    public String deletePermission(Integer id){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        namedParameterJdbcTemplate.update(permissionQueries.getDeletePermission(), params);

        return "Permission borrado con éxito";
    }

    @Override
    public PermissionDTO selectPermissionByObject(PermissionDTO permissionDTO){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("role_id", permissionDTO.getRoleId());
        params.addValue("user_id", permissionDTO.getUserId());
        return permissionMapper.toDTO(namedParameterJdbcTemplate.queryForObject(permissionQueries.getSelectPermissionByObject(), params, new PermissionRowMapper()));
    }

}
