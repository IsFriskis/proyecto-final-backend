package es.tfc.marcosm.domain.repository;

import es.tfc.marcosm.domain.dto.BanDTO;

import java.util.List;

public interface BanRepository {
    List<BanDTO> selectAllBans();

    BanDTO selectBanById(Integer id);

    BanDTO createBan(BanDTO banDTO);

    String closeBan(Integer id);

    BanDTO updateBan(BanDTO banDTO);

    String deleteBan(Integer id);

    String setBanReviewed(Integer id);

    BanDTO selectBanByObject(BanDTO banDTO);
}