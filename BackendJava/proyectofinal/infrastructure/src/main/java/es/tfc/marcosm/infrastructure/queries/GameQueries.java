package es.tfc.marcosm.infrastructure.queries;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = "gameQueries.properties")
public class GameQueries {
    @Value("${selectAllGames}")
    private String selectAllGames;

    @Value("${selectGameById}")
    private String selectGameById;

    @Value("${createGame}")
    private String createGame;
    @Value("${deleteGame}")
    private String deleteGame;

    @Value("${updateGame}")
    private String updateGame;

    @Value("${selectGameByObject}")
    private String selectGameByObject;

}
