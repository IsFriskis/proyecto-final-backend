package es.tfc.marcosm.application.servicios;

import es.tfc.marcosm.domain.dto.BanDTO;
import es.tfc.marcosm.domain.repository.BanRepository;
import es.tfc.marcosm.domain.service.BanServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BanService implements BanServiceInterface {

    @Autowired
    private final BanRepository banRepository;

    @Override
    public List<BanDTO> selectAllBans(){
        return banRepository.selectAllBans();
    }

    @Override
    public BanDTO selectBanById(Integer id){
        return banRepository.selectBanById(id);
    }

    @Override
    public BanDTO createBan(BanDTO banDTO){
        return banRepository.createBan(banDTO);
    }

    @Override
    public  String closeBan(Integer id){
        return banRepository.closeBan(id);
    }

    @Override
    public BanDTO updateBan(Integer id, BanDTO banDTO){
        banDTO.setId(id);
        return banRepository.updateBan(banDTO);
    }

    @Override
    public String deleteBan(Integer id){
        return banRepository.deleteBan(id);
    }

    @Override
    public BanDTO selectBanByObject(BanDTO banDTO){
        return banRepository.selectBanByObject(banDTO);
    }

    @Override
    public String setReviewedBan(Integer id){
        return banRepository.setBanReviewed(id);
    }
}
