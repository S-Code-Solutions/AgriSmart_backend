package lk.smartagri.smartagriapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDTO {

    private int crop_id;
    private String crop_name;
    private String crop_variety;
    private String soil_type;
    private String pesticide_type;
    private String crop_status;

    private List<PlantingDTO> plantings;
    private List<FertilizeDTO> fertilizers;
    private List<HarvestDTO> harvests;

    @JsonIgnore
    private String userID;

}
