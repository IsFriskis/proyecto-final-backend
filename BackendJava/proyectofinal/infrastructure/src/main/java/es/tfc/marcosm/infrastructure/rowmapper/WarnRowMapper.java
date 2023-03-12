package es.tfc.marcosm.infrastructure.rowmapper;

import es.tfc.marcosm.infrastructure.entity.WarnEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.apache.poi.ss.usermodel.DateUtil.toLocalDateTime;

public class WarnRowMapper implements RowMapper<WarnEntity> {


    @Override
    public WarnEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return WarnEntity.builder()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .description(rs.getString("description"))
                .warnLevelId(rs.getInt("warnlevel_id"))
                .date(toLocalDateTime(rs.getTimestamp("date")))
                .userId(rs.getString("user_id"))
                .build();
    }
}
