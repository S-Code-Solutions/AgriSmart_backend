package lk.smartagri.smartagriapi.controller;

import lk.smartagri.smartagriapi.dto.FertilizeDTO;
import lk.smartagri.smartagriapi.dto.HarvestDTO;
import lk.smartagri.smartagriapi.dto.ResponseDTO;
import lk.smartagri.smartagriapi.service.impl.HarvestServiceImpl;
import lk.smartagri.smartagriapi.util.VarListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/harvest")
public class HarvestController {

    @Autowired
    private HarvestServiceImpl harvestService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping("/saveharvest")
    private ResponseEntity<ResponseDTO> saveHarvest(@RequestBody HarvestDTO harvestDTO){

        try {
            String res = harvestService.saveHarvest(harvestDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarListUtil.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }else if (res.equals("01")) {
                responseDTO.setCode(VarListUtil.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Please Use Different Harvest Method");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            } else if (res.equals("06")) {
                responseDTO.setCode(VarListUtil.RSP_DUPLICATED);
                responseDTO.setMessage("Please Use Different Harvest Method");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            } else {
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
