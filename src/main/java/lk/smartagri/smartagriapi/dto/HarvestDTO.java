package lk.smartagri.smartagriapi.dto;

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
    private Crop harvest_method;
    private String harvesting_equipment;
    private String labor_requirement;
    private String storage_requirement;
    private String harvest_quality;
    private String market_destination;
    private String post_harvest_handling;
    private String yield_analysis;
    private String crop_maturity;
    private String harvest_labor_cost;
    private String harvest_transport;
    private String harvest_waste;
    private String harvesting_date;
    private String crop_id;
}
