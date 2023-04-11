package lk.smartagri.smartagriapi.service;

import lk.smartagri.smartagriapi.dto.PlantDTO;

import java.util.List;

public interface PlantingService {

    String savePlant(PlantDTO plantDTO);

    List<PlantDTO> getAllPlantMethods(String username);
}
