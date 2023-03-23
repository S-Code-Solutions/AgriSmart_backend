package lk.smartagri.smartagriapi.service.impl;

import lk.smartagri.smartagriapi.dto.PlantDTO;
import lk.smartagri.smartagriapi.dto.Plant_DetailDTO;
import lk.smartagri.smartagriapi.entity.Plant;
import lk.smartagri.smartagriapi.entity.Plant_Detail;
import lk.smartagri.smartagriapi.repository.PlantDetailRepository;
import lk.smartagri.smartagriapi.repository.PlantingRepository;
import lk.smartagri.smartagriapi.repository.UserRepository;
import lk.smartagri.smartagriapi.service.PlantingService;
import lk.smartagri.smartagriapi.util.VarListUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlantingServiceImpl implements PlantingService {

    @Autowired
    private PlantingRepository plantingRepository;

    @Autowired
    private PlantDetailRepository plantDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public String savePlant(PlantDTO plantDTO) {
        if (plantingRepository.existsByPlantMethod(plantDTO.getPlantMethod())) {
            //createOrder Instance
            return VarListUtil.RSP_NO_DATA_FOUND;
            //orderDetailRepository.saveAll(modelMapper.map(list,listType));
        } else {
            System.out.println(plantDTO.toString());
            plantingRepository.addPlantRecord((String) plantDTO.getPlantMethod(), plantDTO.getMethodDesc());
            return VarListUtil.RSP_SUCCESS;
        }

//        return VarListUtil.RSP_NO_DATA_FOUND;
    }

    @Override
    public String savePlantDtail(Plant_DetailDTO plant_detailDTO) {
//        if (plantDetailRepository.existsByPlant_detail_id(plant_detailDTO.getPlant_detail_id())) {
            //createOrder Instance
//            return VarListUtil.RSP_NO_DATA_FOUND;
            //orderDetailRepository.saveAll(modelMapper.map(list,listType));
//        } else {
            System.out.println(plant_detailDTO.toString());
            plantDetailRepository.addPlantDRecord((Long) plant_detailDTO.getPlant_detail_id(), plant_detailDTO.getPlantMethod(), plant_detailDTO.getPlanting_location(), plant_detailDTO.getPlanting_density(), plant_detailDTO.getSeeding_rate(), plant_detailDTO.getSeeding_depth(), plant_detailDTO.getSoil_preparation(), plant_detailDTO.getPlanting_date(), plant_detailDTO.getWater_duration(), plant_detailDTO.getMessage(), plant_detailDTO.getCrop_id());
            return VarListUtil.RSP_SUCCESS;
//        }
    }

    @Override
    public List<PlantDTO> getAllPlantMethods(String username) {
        List<Plant> plantList = plantingRepository.findAllByUserName(username);
        return modelMapper.map(plantList, new TypeToken<ArrayList<PlantDTO>>(){}.getType());
    }

//    public List<Plant_Detail> getAllPlantings() {
//        Long userId = userService.getCurrentUserId();
//        return plantingRepository.findByUserId(userId);
//    }


    @Scheduled(cron = "0 09 17 * * *")// Runs every day at 9 AM
    public String checkPlantings(String username) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();

        List<Plant_Detail> plantings = PlantDetailRepository.findAllByUserName(username);
        LocalDate today = LocalDate.now();

        String message = null;
        for (Plant_Detail planting : plantings) {
            LocalDate nextWateringDate = planting.getPlanting_date().plusDays(planting.getWater_duration());

            if (nextWateringDate.isEqual(today)) {
//                sendNotification(planting);
                message = "Your " + planting.getCrop_id().getCrop_name() + " plants need watering today.";
            }
        }

        return message;
    }


//    public String sendNotification(Plant_Detail planting) {
//// Create a message containing the planting information
////        String message = "Your " + planting.getCrop_id().getCrop_name() + " plants need watering today.";
//        String message = "Your " + planting.getCrop_id().getCrop_name() + " plants need watering today.";
//
//        // Send the message to the Angular application using a WebSocket
////        SimpMessagingTemplate.convertAndSend("/topic/notifications", message);
//        return message;
//
////        messagingTemplate.convertAndSend("/topic/notifications", message);
//    }

}
