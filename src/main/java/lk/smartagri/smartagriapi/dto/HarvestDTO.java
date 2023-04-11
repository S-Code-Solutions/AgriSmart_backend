package lk.smartagri.smartagriapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.smartagri.smartagriapi.entity.Crop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HarvestDTO {
    @Id
    private long harvest_id;
    private String harvest_method;
    private String harvesting_equipment;
    private String labor_requirement;
    private String storage_requirement;
    private String harvest_quality;
    private String harvest_cost;
    private String harvest_waste;
    private String harvesting_date;
    private String message;

    @JsonIgnore
    private int crop_id;
}
