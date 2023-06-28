package lk.smartagri.smartagriapi.service.impl;

import lk.smartagri.smartagriapi.dto.FertilizeDTO;
import lk.smartagri.smartagriapi.dto.PlantDTO;
import lk.smartagri.smartagriapi.entity.Fertilize;
import lk.smartagri.smartagriapi.entity.Plant;
import lk.smartagri.smartagriapi.repository.FertilizeRepository;
import lk.smartagri.smartagriapi.service.FertilizeService;
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
public class FertilizeServiceImpl implements FertilizeService {

    @Autowired
    private FertilizeRepository fertilizeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveFertilizer(FertilizeDTO fertilizeDTO) {
//        Long plantId = plantDTO.getPlant_id();
        if(fertilizeRepository.existsById(fertilizeDTO.getFertilize_id())){
            return VarListUtil.RSP_NO_DATA_FOUND;
        }else{
            fertilizeRepository.save(modelMapper.map(fertilizeDTO, Fertilize.class));
            return VarListUtil.RSP_SUCCESS;
        }
    }

    @Override
    public List<FertilizeDTO> getAllFertMethods(String username) {
        List<Fertilize> fertilizeList = fertilizeRepository.findAllByUserName(username);
        List<FertilizeDTO> fertilizeDTOList = new ArrayList<>();
        for (Fertilize fertilize : fertilizeList) {
            FertilizeDTO fertilizeDTO = new FertilizeDTO();

            fertilizeDTO.setFertilize_id(fertilize.getFertilize_id());
            fertilizeDTO.setFertilize_name(fertilize.getFertilize_name());
            fertilizeDTO.setFertilizer_type(fertilize.getFertilizer_type());
            fertilizeDTO.setFertilizer_app_method(fertilize.getFertilizer_app_method());
            fertilizeDTO.setFertilizer_app_fre(fertilize.getFertilizer_app_fre());
            fertilizeDTO.setApplication_rate(fertilize.getApplication_rate());
            fertilizeDTO.setFertilizer_placement(fertilize.getFertilizer_placement());
            fertilizeDTO.setApplication_timing(fertilize.getApplication_timing());
            fertilizeDTO.setFertigation(fertilize.getFertigation());
            fertilizeDTO.setFertlizing_date(fertilize.getFertlizing_date());
            fertilizeDTO.setMessage(fertilize.getMessage());

            fertilizeDTOList.add(fertilizeDTO);
        }
        return fertilizeDTOList;

    }
}
