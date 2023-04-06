package lk.smartagri.smartagriapi.service;

import lk.smartagri.smartagriapi.dto.FertilizeDTO;

import java.util.List;

public interface FertilizeService {

    String saveFertilizer(FertilizeDTO fertilizeDTO);

    List<FertilizeDTO> getAllFertMethods(String username);
}
