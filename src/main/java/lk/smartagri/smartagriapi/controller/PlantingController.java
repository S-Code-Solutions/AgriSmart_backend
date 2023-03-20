package lk.smartagri.smartagriapi.controller;

import lk.smartagri.smartagriapi.dto.PlantingDTO;
import lk.smartagri.smartagriapi.dto.ResponseDTO;
import lk.smartagri.smartagriapi.service.impl.PlantingServiceImpl;
import lk.smartagri.smartagriapi.util.VarListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/plant")
public class PlantingController {

    @Autowired
    private PlantingServiceImpl plantingService;

    @Autowired
    private ResponseDTO responseDTO;


    @PostMapping("/saveplant")
    private ResponseEntity<ResponseDTO> saveCrop(@RequestBody PlantingDTO plantingDTO,@RequestAttribute String username){

        try {
//            plantingDTO.setUserId(username);
            String res = plantingService.savePlant(plantingDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarListUtil.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }else if (res.equals("01")) {
                responseDTO.setCode(VarListUtil.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Please Use Different CropID");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }  else {
                responseDTO.setCode(VarListUtil.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseDTO.setCode(VarListUtil.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
