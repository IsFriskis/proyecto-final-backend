package es.tfc.marcosm.infrastructure.rowmapper;

import es.tfc.marcosm.infrastructure.entity.RoleEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<RoleEntity> {
    @Override
    public RoleEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return RoleEntity.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .description(rs.getString("description"))
                .build();
    }
}
