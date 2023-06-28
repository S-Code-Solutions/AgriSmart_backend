package lk.smartagri.smartagriapi.controller;

import lk.smartagri.smartagriapi.dto.CropDTO;
import lk.smartagri.smartagriapi.dto.ResponseDTO;
import lk.smartagri.smartagriapi.service.impl.CropServiceImpl;
import lk.smartagri.smartagriapi.util.FileUploadUtil;
import lk.smartagri.smartagriapi.util.VarListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/crop")
public class CropManageController {

    @Autowired
    private CropServiceImpl cropService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/uploadProductImage")
    public ResponseEntity<ResponseDTO> uploadProductImage(@RequestParam("files") MultipartFile[] files) {
        try{
            String uploadDir="cropImages";
            Arrays.stream(files).forEach(file -> {
                String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
                System.out.println(fileName);
                try {
                    FileUploadUtil.saveFile(uploadDir, fileName, file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            responseDTO.setCode(VarListUtil.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(null);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }catch (Exception e){
            responseDTO.setCode(VarListUtil.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/savecrop")
    private ResponseEntity<ResponseDTO> saveCrop(@RequestBody CropDTO cropDTO,@RequestAttribute String username){

        try {
            cropDTO.setUsername(username);
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
            } else if (res.equals("06")) {
                responseDTO.setCode(VarListUtil.RSP_DUPLICATED);
                responseDTO.setMessage("Please Use Different Crop Name");
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

    @GetMapping("/getCrop")
    private ResponseEntity<ResponseDTO> getUniqueProduct(@RequestParam String name){
        try {
            List<CropDTO> cropDTO = cropService.getCrop(name);
            responseDTO.setCode(VarListUtil.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(cropDTO);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        }catch (Exception ex){
            responseDTO.setCode(VarListUtil.RSP_ERROR);
            responseDTO.setMessage("Error");
            responseDTO.setContent(ex.getMessage());
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
