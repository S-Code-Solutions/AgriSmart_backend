package lk.smartagri.smartagriapi.service.impl;

import lk.smartagri.smartagriapi.dto.CropDTO;
import lk.smartagri.smartagriapi.entity.Crop;
import lk.smartagri.smartagriapi.repository.CropRepository;
import lk.smartagri.smartagriapi.service.CropService;
import lk.smartagri.smartagriapi.util.VarListUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ModelMapper modelMapper;

    @Override
    public String saveCrop(CropDTO cropDTO) {
        if (cropRepository.existsById(cropDTO.getCrop_id())) {
            return VarListUtil.RSP_NO_DATA_FOUND;
        } else {
            System.out.println(cropDTO.toString());
            cropRepository.addCropRecorde((int) cropDTO.getCrop_id(),cropDTO.getCrop_name(),
                    cropDTO.getCrop_variety(),cropDTO.getPlanting_date(),cropDTO.getHarvest_date(),
                    cropDTO.getExpected_yield(),cropDTO.getSoil_type(),cropDTO.getFertilizer_control(),
                    cropDTO.getPesticide_type(),cropDTO.getCrop_status(),cropDTO.getCost(),cropDTO.getLocation(),cropDTO.getUserId()
            );
            return VarListUtil.RSP_SUCCESS;
        }

    }


    @Override
    public List<CropDTO> getAllCropItems(String username) {
        List<Crop> cropList=cropRepository.findAllByUserName(username);
        return modelMapper.map(cropList, new TypeToken<ArrayList<CropDTO>>() {
        }.getType());
    }
}
