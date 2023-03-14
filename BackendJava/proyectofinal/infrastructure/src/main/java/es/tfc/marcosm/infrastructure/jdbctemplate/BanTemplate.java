package es.tfc.marcosm.infrastructure.jdbctemplate;

import es.tfc.marcosm.domain.repository.BanRepository;
import es.tfc.marcosm.infrastructure.mapper.BanMapperDTO;
import es.tfc.marcosm.infrastructure.queries.BanQueries;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class BanTemplate implements BanRepository {

    @Autowired
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private final BanMapperDTO banMapper;

    @Autowired
    private final BanQueries banQueries;

}
