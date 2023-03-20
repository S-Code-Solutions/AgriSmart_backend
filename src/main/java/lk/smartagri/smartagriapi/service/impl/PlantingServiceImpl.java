package lk.smartagri.smartagriapi.service.impl;

import lk.smartagri.smartagriapi.dto.PlantingDTO;
import lk.smartagri.smartagriapi.repository.PlantingRepository;
import lk.smartagri.smartagriapi.repository.UserRepository;
import lk.smartagri.smartagriapi.service.PlantingService;
import lk.smartagri.smartagriapi.util.VarListUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlantingServiceImpl implements PlantingService {

    @Autowired
    private PlantingRepository plantingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public String savePlant(PlantingDTO plantingDTO) {
//                if (userRepository.existsByUsername(plantingDTO.getUserID())) {
//            //createOrder Instance
//                    plantingRepository.addCropRecorde(cropDTO.getCrop_id(),cropDTO.getCrop_name(),cropDTO.getCrop_variety(),cropDTO.getUserID());
//
//            //orderDetailRepository.saveAll(modelMapper.map(list,listType));
//            return VarListUtil.RSP_SUCCESS;
//        }

        return VarListUtil.RSP_SUCCESS;
    }
}
