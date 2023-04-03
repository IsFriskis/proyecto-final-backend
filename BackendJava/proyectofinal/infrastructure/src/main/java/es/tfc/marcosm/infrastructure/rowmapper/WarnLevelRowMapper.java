package es.tfc.marcosm.infrastructure.rowmapper;

import es.tfc.marcosm.infrastructure.entity.WarnLevelEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WarnLevelRowMapper implements RowMapper<WarnLevelEntity> {
    @Override
    public WarnLevelEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return WarnLevelEntity.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .description(rs.getString("description"))
                .build();
    }
}
