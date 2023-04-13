package es.tfc.marcosm.infrastructure.queries;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = "userQueries.properties")
public class UserQueries {

    @Value("${selectAllUsers}")
    private String selectAllUsers;

    @Value("${selectUserById}")
    private String selectUserById;

    @Value("${selectUserByMail}")
    private String selectUserByMail;

    @Value("${selectUserByObject}")
    private String selectUserByObject;

    @Value("${createUser}")
    private String createUser;

    @Value("${updateUser}")
    private String updateUser;

    @Value("${deleteUser}")
    private String deleteUser;

    @Value("${selectUsersByNameFilter}")
    private String selectUsersByNameFilter;

    @Value("${selectPageableLimit}")
    private String selectPageableLimit;

}
