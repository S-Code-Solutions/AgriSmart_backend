package lk.smartagri.smartagriapi.service.impl;

import lk.smartagri.smartagriapi.dto.FertilizeDTO;
import lk.smartagri.smartagriapi.dto.HarvestDTO;
import lk.smartagri.smartagriapi.entity.Fertilize;
import lk.smartagri.smartagriapi.entity.Harvest;
import lk.smartagri.smartagriapi.repository.HarvestRepository;
import lk.smartagri.smartagriapi.service.HarvestService;
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
public class HarvestServiceImpl implements HarvestService {

    @Autowired
    private HarvestRepository harvestRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveHarvest(HarvestDTO harvestDTO) {
        if (harvestRepository.exitBHarvest_id(harvestDTO.getHarvest_id())){
            return VarListUtil.RSP_NO_DATA_FOUND;
        }else{
            harvestRepository.save(modelMapper.map(harvestDTO, Harvest.class));
            return VarListUtil.RSP_SUCCESS;
        }
    }

    @Override
    public List<HarvestDTO> getAllHarvestMethods(String username) {
        List<Harvest> harvestList = harvestRepository.findAllByUserName(username);
        return modelMapper.map(harvestList, new TypeToken<ArrayList<HarvestDTO>>(){}.getType());
    }
}
