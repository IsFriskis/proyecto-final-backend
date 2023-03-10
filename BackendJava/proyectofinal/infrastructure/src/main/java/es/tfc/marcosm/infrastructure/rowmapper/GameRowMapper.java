package es.tfc.marcosm.infrastructure.rowmapper;

import es.tfc.marcosm.infrastructure.entity.GameEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.apache.poi.ss.usermodel.DateUtil.toLocalDateTime;

public class GameRowMapper implements RowMapper<GameEntity> {
    @Override
    public GameEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return GameEntity.builder()
                .id(rs.getInt("id"))
                .score(rs.getFloat("score"))
                .date(toLocalDateTime(rs.getTimestamp("date")))
                .userId(rs.getInt("user_id"))
                .build();
    }
}
