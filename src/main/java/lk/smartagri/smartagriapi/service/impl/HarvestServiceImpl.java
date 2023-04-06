package lk.smartagri.smartagriapi.service.impl;

import lk.smartagri.smartagriapi.dto.HarvestDTO;
import lk.smartagri.smartagriapi.entity.Harvest;
import lk.smartagri.smartagriapi.repository.HarvestRepository;
import lk.smartagri.smartagriapi.service.HarvestService;
import lk.smartagri.smartagriapi.util.VarListUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HarvestServiceImpl implements HarvestService {

    @Autowired
    private HarvestRepository harvestRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveHarvest(HarvestDTO harvestDTO) {
        if (harvestRepository.existByHarvest_id(harvestDTO.getHarvest_id())){
            return VarListUtil.RSP_NO_DATA_FOUND;
        }else{
            harvestRepository.save(modelMapper.map(harvestDTO, Harvest.class));
            return VarListUtil.RSP_SUCCESS;
        }
    }
}
