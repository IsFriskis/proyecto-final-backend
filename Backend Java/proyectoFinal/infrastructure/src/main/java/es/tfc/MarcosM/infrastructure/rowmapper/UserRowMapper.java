package es.tfc.MarcosM.infrastructure.rowmapper;

import es.tfc.MarcosM.infrastructure.entity.UserEntity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRowMapper implements RowMapper<UserEntity> {
    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return UserEntity.builder()
                .id(rs.getString("id"))
                .username(rs.getString("username"))
                .mail(rs.getString("mail"))
                .password(rs.getString(("password")))
                .build();
    }
}
