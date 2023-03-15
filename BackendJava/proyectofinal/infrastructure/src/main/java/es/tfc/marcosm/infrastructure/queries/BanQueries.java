package es.tfc.marcosm.infrastructure.queries;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = "banQueries.properties")
public class BanQueries {

    @Value("${selectAllBans}")
    private String selectAllBans;

    @Value("${selectBanById}")
    private String selectBanById;

    @Value("${createBan}")
    private String createBan;

    @Value("${closeBan}")
    private String closeBan;

    @Value("${deleteBan}")
    private String deleteBan;

    @Value("${updateBan}")
    private String updateBan;

    @Value("${selectBanByObject}")
    private String selectBanByObject;



}
