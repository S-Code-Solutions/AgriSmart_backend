package lk.smartagri.smartagriapi.service.impl;

import lk.smartagri.smartagriapi.dto.CropDTO;
import lk.smartagri.smartagriapi.dto.FertilizeDTO;
import lk.smartagri.smartagriapi.dto.HarvestDTO;
import lk.smartagri.smartagriapi.dto.PlantingDTO;
import lk.smartagri.smartagriapi.entity.Crop;
import lk.smartagri.smartagriapi.repository.CropRepository;
import lk.smartagri.smartagriapi.repository.UserRepository;
import lk.smartagri.smartagriapi.service.CropService;
import lk.smartagri.smartagriapi.util.VarListUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CropServiceImpl implements CropService {

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveCrop(CropDTO cropDTO) {
        if (cropRepository.existsById(cropDTO.getCrop_id())) {
            return VarListUtil.RSP_NO_DATA_FOUND;
        }
        else {
            System.out.println(cropDTO.toString());
            cropRepository.addCropRecorde((int) cropDTO.getCrop_id(),cropDTO.getCrop_name(),
                    cropDTO.getCrop_variety(),cropDTO.getImageURL(),
                    cropDTO.getCrop_status(),cropDTO.getUsername());
            return VarListUtil.RSP_SUCCESS;
        }
    }


    @Override
    public List<CropDTO> getAllCropItems(String username) {
        List<Crop> cropList=cropRepository.findAllByUserName(username);
        return modelMapper.map(cropList, new TypeToken<ArrayList<CropDTO>>() {
        }.getType());
    }

    @Override
    public List<CropDTO> getCrop(String name) {
        List<Crop> crop= cropRepository.findByNameLike(name);
        return modelMapper.map(crop, new TypeToken<ArrayList<CropDTO>>() {
        }.getType());
    }
}
