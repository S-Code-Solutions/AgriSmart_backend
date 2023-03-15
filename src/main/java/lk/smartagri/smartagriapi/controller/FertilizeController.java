package lk.smartagri.smartagriapi.controller;

import lk.smartagri.smartagriapi.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fertilizer")
public class FertilizeController {


    @Autowired
    private ResponseDTO responseDTO;
}
