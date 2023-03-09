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
}
