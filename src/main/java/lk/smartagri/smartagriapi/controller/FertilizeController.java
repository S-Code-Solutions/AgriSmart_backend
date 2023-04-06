package lk.smartagri.smartagriapi.controller;

import lk.smartagri.smartagriapi.dto.FertilizeDTO;
import lk.smartagri.smartagriapi.dto.PlantDTO;
import lk.smartagri.smartagriapi.dto.ResponseDTO;
import lk.smartagri.smartagriapi.service.impl.FertilizeServiceImpl;
import lk.smartagri.smartagriapi.util.VarListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/fertilizer")
public class FertilizeController {

    @Autowired
    private FertilizeServiceImpl fertilizeService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping("/savefert")
    private ResponseEntity<ResponseDTO> savePlant(@RequestBody FertilizeDTO fertilizeDTO){

        try {
            String res = fertilizeService.saveFertilizer(fertilizeDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarListUtil.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }else if (res.equals("01")) {
                responseDTO.setCode(VarListUtil.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Please Use Different Fertilizer Method");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            } else if (res.equals("06")) {
                responseDTO.setCode(VarListUtil.RSP_DUPLICATED);
                responseDTO.setMessage("Please Use Different Fertilizer Method");
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


    @GetMapping("/getallferts")
    public ResponseEntity<ResponseDTO> getAllFertMethods(@RequestAttribute String username,@RequestAttribute String role) {
        try{
            System.out.println(username);
            System.out.println(role);
            List<FertilizeDTO> fertilizeDTO = fertilizeService.getAllFertMethods(username);
            responseDTO.setCode(VarListUtil.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(fertilizeDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
        }catch (Exception e){
            responseDTO.setCode(VarListUtil.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
