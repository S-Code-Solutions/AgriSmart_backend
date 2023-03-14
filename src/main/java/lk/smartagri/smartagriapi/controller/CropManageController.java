package lk.smartagri.smartagriapi.controller;

import lk.smartagri.smartagriapi.dto.CropDTO;
import lk.smartagri.smartagriapi.dto.ResponseDTO;
import lk.smartagri.smartagriapi.service.impl.CropServiceImpl;
import lk.smartagri.smartagriapi.util.VarListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/crop")
public class CropManageController {

    @Autowired
    private CropServiceImpl cropService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping("/savecrop")
    private ResponseEntity<ResponseDTO> saveCrop(@RequestBody CropDTO cropDTO,@RequestAttribute String username){

        try {
            cropDTO.setUserId(username);
            String res = cropService.saveCrop(cropDTO);
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
    @GetMapping("/getall")
    public ResponseEntity<ResponseDTO> getAllCropItems(@RequestAttribute String username,@RequestAttribute String role) {
        try{
            System.out.println(username);
            System.out.println(role);
            List<CropDTO> cropDTOS = cropService.getAllCropItems(username);
            responseDTO.setCode(VarListUtil.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(cropDTOS);
            return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
        }catch (Exception e){
            responseDTO.setCode(VarListUtil.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
