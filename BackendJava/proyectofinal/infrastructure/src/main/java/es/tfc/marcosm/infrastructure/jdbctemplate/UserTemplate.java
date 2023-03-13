package es.tfc.marcosm.infrastructure.jdbctemplate;

import es.tfc.marcosm.domain.dto.UserDTO;
import es.tfc.marcosm.domain.repository.UserRepository;
import es.tfc.marcosm.infrastructure.mapper.UserMapperDTO;
import es.tfc.marcosm.infrastructure.queries.UserQueries;
import es.tfc.marcosm.infrastructure.rowmapper.UserRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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

    @Override
    public UserDTO selectUserById(String id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return userMapper.toDTO(namedParameterJdbcTemplate.queryForObject(userQueries.getSelectUserById(), params, new UserRowMapper()));
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("username", userDTO.getUsername());
        params.addValue("mail", userDTO.getMail());
        params.addValue("password", userDTO.getPassword());

        namedParameterJdbcTemplate.update(userQueries.getCreateUser(), params);

        //TODO: create permission with roles too
        return selectUserByObject(userDTO);
    }

    @Override
    public String deleteUser(String id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        namedParameterJdbcTemplate.update(userQueries.getDeleteUser(), params);

        return "Usuario borrado con éxito";
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        UserDTO userOriginal = selectUserById(userDTO.getId());
        UserDTO toReturn = new UserDTO();
        params.addValue("id", userDTO.getId());

        if(userDTO.getUsername()!= null) {
            params.addValue("username", userDTO.getUsername());
            toReturn.setUsername(userDTO.getUsername());
        } else{
            params.addValue("username",userOriginal.getUsername());
            toReturn.setUsername(userOriginal.getUsername());
        }

        if(userDTO.getMail()!= null) {
            params.addValue("mail", userDTO.getMail());
            toReturn.setMail(userDTO.getMail());
        } else{
            params.addValue("mail",userOriginal.getMail());
            toReturn.setMail(userOriginal.getMail());
        }


        namedParameterJdbcTemplate.update(userQueries.getUpdateUser(), params);

        return selectUserById(userDTO.getId());

    }

    @Override
    public UserDTO selectUserByObject(UserDTO userDTO) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("username", userDTO.getUsername());
        params.addValue("mail", userDTO.getMail());
        params.addValue("password", userDTO.getPassword());

        return userMapper.toDTO(namedParameterJdbcTemplate.queryForObject(userQueries.getSelectUserByObject(), params, new UserRowMapper()));
    }
}
