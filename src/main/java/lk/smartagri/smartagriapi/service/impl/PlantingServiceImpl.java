package lk.smartagri.smartagriapi.service.impl;

import lk.smartagri.smartagriapi.dto.PlantDTO;
import lk.smartagri.smartagriapi.entity.Plant;
import lk.smartagri.smartagriapi.repository.PlantingRepository;
import lk.smartagri.smartagriapi.repository.UserRepository;
import lk.smartagri.smartagriapi.service.PlantingService;
import lk.smartagri.smartagriapi.util.VarListUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public String savePlant(PlantDTO plantDTO) {
        Long plantId = plantDTO.getPlant_id();
        if (plantingRepository.existsById(plantDTO.getPlant_id())) {
            //createOrder Instance
            return VarListUtil.RSP_NO_DATA_FOUND;
            //orderDetailRepository.saveAll(modelMapper.map(list,listType));
        } else {
            System.out.println(plantDTO.toString());
//            plantingRepository.save(modelMapper.map(plantDTO, Plant.class));
            plantingRepository.addPLantRecord((int) plantDTO.getPlant_id(),plantDTO.getPlantMethod(),
                    plantDTO.getPlanting_date(),plantDTO.getPlanting_density(), plantDTO.getPlanting_location(),
                    plantDTO.getSeeding_depth(), plantDTO.getSeeding_rate(), plantDTO.getSoil_preparation(),
                    plantDTO.getWater_duration(), plantDTO.getMessage(), plantDTO.getCrop_id()
                    );
//            plantingRepository.addPlantRecord((String) plantDTO.getPlantMethod(), plantDTO.getMethodDesc());
            return VarListUtil.RSP_SUCCESS;
        }

//        return VarListUtil.RSP_NO_DATA_FOUND;
    }


    @Override
    public List<PlantDTO> getAllPlantMethods(String username) {
        List<Plant> plantList = plantingRepository.findAllByUserName(username);
        List<PlantDTO> plantDTOList = new ArrayList<>();
        for (Plant plant : plantList) {
            PlantDTO plantDTO = new PlantDTO();
//            // map each field from Plant to PlantDTO
            plantDTO.setPlant_id(plant.getPlant_id());
            plantDTO.setPlantMethod(plant.getPlantMethod());
            plantDTO.setPlanting_date(plant.getPlanting_date());
            plantDTO.setPlanting_density(plant.getPlanting_density());
            plantDTO.setPlanting_location(plant.getPlanting_location());
            plantDTO.setSeeding_depth(plant.getSeeding_depth());
            plantDTO.setSeeding_rate(plant.getSeeding_rate());
            plantDTO.setSoil_preparation(plant.getSoil_preparation());
            plantDTO.setWater_duration(plant.getWater_duration());
            plantDTO.setMessage(plant.getMessage());

            plantDTOList.add(plantDTO);
        }
        return plantDTOList;

    }

//    public List<Plant_Detail> getAllPlantings() {
//        Long userId = userService.getCurrentUserId();
//        return plantingRepository.findByUserId(userId);
//    }


//    @Scheduled(cron = "0 09 17 * * *")// Runs every day at 9 AM
//    public String checkPlantings(String username) {
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        String username = authentication.getName();
//
//        List<Plant_Detail> plantings = PlantDetailRepository.findAllByUserName(username);
//        LocalDate today = LocalDate.now();
//
//        String message = null;
//        for (Plant_Detail planting : plantings) {
//            LocalDate nextWateringDate = planting.getPlanting_date().plusDays(planting.getWater_duration());
//
//            if (nextWateringDate.isEqual(today)) {
////                sendNotification(planting);
//                message = "Your " + planting.getCrop_id().getCrop_name() + " plants need watering today.";
//            }
//        }
//
//        return message;
//    }


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
