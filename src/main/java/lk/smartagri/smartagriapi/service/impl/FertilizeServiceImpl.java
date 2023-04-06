package lk.smartagri.smartagriapi.service.impl;

import lk.smartagri.smartagriapi.dto.FertilizeDTO;
import lk.smartagri.smartagriapi.entity.Fertilize;
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
        if(fertilizeRepository.existsByFertilize_id(fertilizeDTO.getFertilize_id())){
            return VarListUtil.RSP_NO_DATA_FOUND;
        }else{
            fertilizeRepository.save(modelMapper.map(fertilizeDTO, Fertilize.class));
            return VarListUtil.RSP_SUCCESS;
        }
    }

    @Override
    public List<FertilizeDTO> getAllFertMethods(String username) {
        List<Fertilize> fertilizeList = fertilizeRepository.findAllByUserName(username);
        return modelMapper.map(fertilizeList, new TypeToken<ArrayList<FertilizeDTO>>(){}.getType());
    }
}
