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
        if (userRepository.existsByUsername(cropDTO.getUserID())) {
            //createOrder Instance
            cropRepository.addCropRecorde(cropDTO.getCrop_id(),cropDTO.getCrop_name(),cropDTO.getCrop_variety(),cropDTO.getSoil_type(),cropDTO.getPesticide_type(),cropDTO.getCrop_status(),cropDTO.getUserID());

            List<PlantingDTO> list1 = cropDTO.getPlantings();
            List<FertilizeDTO> list2 = cropDTO.getFertilizers();
            List<HarvestDTO> list3 = cropDTO.getHarvests();
            //saveAll OrderDetails
            //Type listType = new TypeToken<List<OrderDetails>>(){}.getType();


            list1.forEach(e -> {
                String planting_id = cropRepository.getLastPlanting_id();
                orderDetailRepository.placeOrder(e.getOrderDetailsId(), e.getQty(), oderid, e.getProductID());
            });

            list2.forEach(e -> {
                String fert_id = cropRepository.getLastOrderId();
                orderDetailRepository.placeOrder(e.getOrderDetailsId(), e.getQty(), oderid, e.getProductID());
            });

            list3.forEach(e -> {
                String harvest_id = cropRepository.getLastOrderId();
                orderDetailRepository.placeOrder(e.getOrderDetailsId(), e.getQty(), oderid, e.getProductID());
            });
            cartRepository.changeCartStatusByUserName(orderDTO.getUserID());

            //orderDetailRepository.saveAll(modelMapper.map(list,listType));
            return VarListUtil.RSP_SUCCESS;
        }

        return VarListUtil.RSP_ERROR;
    }


    @Override
    public List<CropDTO> getAllCropItems(String username) {
        List<Crop> cropList=cropRepository.findAllByUserName(username);
        return modelMapper.map(cropList, new TypeToken<ArrayList<CropDTO>>() {
        }.getType());
    }
}
