package es.tfc.marcosm.infrastructure.rowmapper;

import es.tfc.marcosm.infrastructure.entity.PermissionEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PermissionRowMapper implements RowMapper<PermissionEntity> {

    @Override
    public PermissionEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PermissionEntity.builder()
                .id(rs.getInt("id"))
                .roleId(rs.getInt("role_id"))
                .userId(rs.getString("user_id"))
                .build();
    }
}
