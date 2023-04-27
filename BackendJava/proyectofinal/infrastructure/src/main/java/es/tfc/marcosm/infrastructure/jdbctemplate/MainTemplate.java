package es.tfc.marcosm.infrastructure.jdbctemplate;

import es.tfc.marcosm.domain.repository.MainRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@AllArgsConstructor
public class MainTemplate implements MainRepository {

    private final String DEFAULT_URL = "http://localhost:8084";
    @Override
    public Boolean isApplicationStatus(){
        return allControllersStatus();
    }

    private Boolean allControllersStatus(){
        if (banControllerStatus()
        && gameControllerStatus()
        && permissionControllerStatus()
        && roleControllerStatus()
        && userControllerStatus()
        && warnControllerStatus()
        && warnLevelControllerStatus()) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean banControllerStatus(){
        RestTemplate restTemplate = new RestTemplate();
        String url = DEFAULT_URL + "/ban/status";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().value() == 200) {
            return true;
        } else {
            return false;
        }
    }
    private Boolean gameControllerStatus(){
        RestTemplate restTemplate = new RestTemplate();
        String url = DEFAULT_URL + "/game/status";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().value() == 200) {
            return true;
        } else {
            return false;
        }
    }
    private Boolean permissionControllerStatus(){
        RestTemplate restTemplate = new RestTemplate();
        String url = DEFAULT_URL + "/permission/status";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().value() == 200) {
            return true;
        } else {
            return false;
        }
    }
    private Boolean roleControllerStatus(){
        RestTemplate restTemplate = new RestTemplate();
        String url = DEFAULT_URL + "/role/status";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().value() == 200) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean userControllerStatus(){
        RestTemplate restTemplate = new RestTemplate();
        String url = DEFAULT_URL + "/user/status";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().value() == 200) {
            return true;
        } else {
            return false;
        }
    }
    private Boolean warnControllerStatus(){
        RestTemplate restTemplate = new RestTemplate();
        String url = DEFAULT_URL + "/warn/status";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().value() == 200) {
            return true;
        } else {
            return false;
        }
    }
    private Boolean warnLevelControllerStatus(){
        RestTemplate restTemplate = new RestTemplate();
        String url = DEFAULT_URL + "/warnlevel/status";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().value() == 200) {
            return true;
        } else {
            return false;
        }
    }
}
