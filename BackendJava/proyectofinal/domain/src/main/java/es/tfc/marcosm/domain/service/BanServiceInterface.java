package es.tfc.marcosm.domain.service;

import es.tfc.marcosm.domain.dto.BanDTO;

import java.util.List;

public interface BanServiceInterface {
    List<BanDTO> selectAllBans();

    BanDTO selectBanById(Integer id);

    BanDTO createBan(BanDTO banDTO);

    String closeBan(Integer id);

    BanDTO updateBan(Integer id, BanDTO banDTO);

    String deleteBan(Integer id);

    BanDTO selectBanByObject(BanDTO banDTO);
}
