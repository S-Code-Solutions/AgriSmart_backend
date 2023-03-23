package lk.smartagri.smartagriapi.service;

import lk.smartagri.smartagriapi.dto.PlantDTO;
import lk.smartagri.smartagriapi.dto.Plant_DetailDTO;
import lk.smartagri.smartagriapi.dto.PlantingDTO;

import java.util.List;

public interface PlantingService {

    String savePlant(PlantDTO plantDTO);

    String savePlantDtail(Plant_DetailDTO plant_detailDTO);

    List<PlantDTO> getAllPlantMethods(String username);
}
