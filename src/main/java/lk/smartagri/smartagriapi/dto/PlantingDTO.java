package lk.smartagri.smartagriapi.dto;

import lk.smartagri.smartagriapi.entity.Crop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlantingDTO {
    @Id
    private long planting_id;
    private String crop_name;
    private String planting_location;
    private String planting_density;
    private String seeding_rate;
    private String seeding_depth;
    private Crop planting_method;
    private String soil_preparation;
    private String planting_date;
    private String crop_id;
}
