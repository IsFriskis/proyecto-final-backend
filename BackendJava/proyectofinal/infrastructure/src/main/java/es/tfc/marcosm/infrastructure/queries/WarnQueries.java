package es.tfc.marcosm.infrastructure.queries;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = "warnQueries.properties")
public class WarnQueries {
    @Value("${selectAllWarns}")
    private String selectAllWarns;

    @Value("${selectWarnById}")
    private String selectWarnById;

    @Value("${createWarn}")
    private String createWarn;

    @Value("${deleteWarn}")
    private String deleteWarn;

    @Value("${updateWarn}")
    private String updateWarn;

    @Value("${selectWarnByObject}")
    private String selectWarnByObject;

    @Value("${selectWarnsByUserId}")
    private String selectWarnsByUserId;

    @Value("${selectWarnsAmountByUserId}")
    private String selectWarnsAmountByUserId;
}
