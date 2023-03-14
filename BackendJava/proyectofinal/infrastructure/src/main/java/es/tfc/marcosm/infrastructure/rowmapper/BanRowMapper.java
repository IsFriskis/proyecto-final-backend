package es.tfc.marcosm.infrastructure.rowmapper;

import es.tfc.marcosm.infrastructure.entity.BanEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.apache.poi.ss.usermodel.DateUtil.toLocalDateTime;

public class BanRowMapper implements RowMapper<BanEntity> {
    @Override
    public BanEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return BanEntity.builder()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .description(rs.getString("description"))
                .timestart(toLocalDateTime(rs.getTimestamp("timestart")))
                .timeend(toLocalDateTime(rs.getTimestamp("timeend")))
                .review(rs.getBoolean("review"))
                .userId(rs.getString("user_id"))
                .build();
    }
}
