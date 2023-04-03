package es.tfc.marcosm.infrastructure.queries;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = "warnLevelQueries.properties")
public class WarnLevelQueries {

    @Value("${selectAllWarnLevels}")
    private String selectAllWarnLevels;

    @Value("${selectWarnLevelById}")
    private String selectWarnLevelById;

    @Value("${createWarnLevel}")
    private String createWarnLevel;

    @Value("${deleteWarnLevel}")
    private String deleteWarnLevel;
    @Value("${updateWarnLevel}")
    private String updateWarnLevel;

    @Value("${selectWarnLevelByObject}")
    private String selectWarnLevelByObject;
}
