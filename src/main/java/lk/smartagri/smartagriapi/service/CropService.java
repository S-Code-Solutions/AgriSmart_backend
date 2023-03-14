package lk.smartagri.smartagriapi.service;

import lk.smartagri.smartagriapi.dto.CropDTO;

import java.util.List;

public interface CropService {

    String saveCrop(CropDTO cropDTO);

    List<CropDTO> getAllCropItems(String username);

}
