package es.tfc.marcosm.infrastructure.jdbctemplate;

import es.tfc.marcosm.domain.dto.UserDTO;
import es.tfc.marcosm.domain.repository.UserRepository;
import es.tfc.marcosm.infrastructure.mapper.UserMapperDTO;
import es.tfc.marcosm.infrastructure.queries.UserQueries;
import es.tfc.marcosm.infrastructure.rowmapper.UserRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserTemplate implements UserRepository {

    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private final UserQueries userQueries;

    @Autowired
    private final UserMapperDTO userMapper;

    @Override
    public List<UserDTO> selectAllUsers() {
        return userMapper.toDTOList(namedParameterJdbcTemplate.query(userQueries.getSelectAllUsers(), new UserRowMapper()));
    }
}
