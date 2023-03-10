package es.tfc.marcosm.infrastructure.jdbctemplate;

import es.tfc.marcosm.domain.dto.RoleDTO;
import es.tfc.marcosm.domain.repository.RoleRepository;
import es.tfc.marcosm.infrastructure.mapper.RoleMapperDTO;
import es.tfc.marcosm.infrastructure.queries.RoleQueries;
import es.tfc.marcosm.infrastructure.rowmapper.RoleRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;

@Repository
@AllArgsConstructor
public class RoleTemplate implements RoleRepository {

    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private final RoleQueries roleQueries;

    @Autowired
    private final RoleMapperDTO roleMapper;
    @Override
    public List<RoleDTO> selectAllRoles(){
        return roleMapper.toDTOList(namedParameterJdbcTemplate.query(roleQueries.getSelectAllRoles(), new RoleRowMapper()));
    }

    @Override
    public RoleDTO selectRoleById(Integer id){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return roleMapper.toDTO(namedParameterJdbcTemplate.queryForObject(roleQueries.getSelectRoleById(), params, new RoleRowMapper()));
    }

    @Override
    public RoleDTO createRole(RoleDTO roleDTO){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", roleDTO.getName());
        params.addValue("description", roleDTO.getDescription());

        namedParameterJdbcTemplate.update(roleQueries.getCreateRole(), params);

        return selectRoleByObject(roleDTO);
    }

    @Override
    public String deleteRole(Integer id){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        namedParameterJdbcTemplate.update(roleQueries.getDeleteRole(), params);

        return "Role borrado con éxito";
    }

    @Override
    public RoleDTO updateRole(RoleDTO roleDTO){
        MapSqlParameterSource params = new MapSqlParameterSource();
        RoleDTO roleOriginal = selectRoleById(roleDTO.getId());
        RoleDTO toReturn = new RoleDTO();
        if(roleDTO.getId() != null){
            params.addValue("id", roleDTO.getId());
            toReturn.setId(roleDTO.getId());
        }else{
            params.addValue("id", roleOriginal.getId());
            toReturn.setId(roleOriginal.getId());
        }

        if(roleDTO.getName()!= null){
            params.addValue("name", roleDTO.getName());
            toReturn.setName(roleDTO.getName());
        } else{
            params.addValue("name", roleOriginal.getName());
            toReturn.setName(roleOriginal.getName());
        }
        if(roleDTO.getDescription()!= null){
            params.addValue("description", roleDTO.getDescription());
            toReturn.setDescription(roleDTO.getDescription());
        }else{
            params.addValue("description", roleOriginal.getDescription());
            toReturn.setDescription(roleOriginal.getDescription());
        }

        namedParameterJdbcTemplate.update(roleQueries.getUpdateRole(), params);

        return selectRoleById(roleDTO.getId());
    }

    @Override
    public RoleDTO selectRoleByObject(RoleDTO roleDTO){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", roleDTO.getName());
        params.addValue("description", roleDTO.getDescription());

        return roleMapper.toDTO(namedParameterJdbcTemplate.queryForObject(roleQueries.getSelectRoleByObject(), params, new RoleRowMapper()));
    }
}
