package lk.smartagri.smartagriapi.service;

import lk.smartagri.smartagriapi.dto.HarvestDTO;

import java.util.List;

public interface HarvestService {

    String saveHarvest(HarvestDTO harvestDTO);

    List<HarvestDTO> getAllHarvestMethods(String username);
}
