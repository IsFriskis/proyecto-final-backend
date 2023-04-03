package es.tfc.marcosm.application.servicios;

import es.tfc.marcosm.domain.repository.MainRepository;
import es.tfc.marcosm.domain.service.MainServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MainService implements MainServiceInterface {

    @Autowired
    private final MainRepository mainRepository;

    @Override
    public Boolean allControllerStatus(){
        return mainRepository.isApplicationStatus();
    }

}
