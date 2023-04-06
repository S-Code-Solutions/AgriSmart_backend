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
public class PlantDTO {
    @Id
    private long plant_id;
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
