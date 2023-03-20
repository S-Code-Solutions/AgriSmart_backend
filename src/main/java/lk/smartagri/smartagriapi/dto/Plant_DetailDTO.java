package lk.smartagri.smartagriapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plant_DetailDTO {
    @Id
    private long plant_detail_id;

    @JsonIgnore
    private String plantMethod;

    private String planting_location;
    private String planting_density;
    private String seeding_rate;
    private String seeding_depth;
    private String soil_preparation;
    private LocalDate planting_date;
    private int water_duration;
    private String message;

    @JsonIgnore
    private int crop_id;
}
