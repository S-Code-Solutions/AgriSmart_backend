package lk.smartagri.smartagriapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "harvest")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long harvest_id;
    private String harvest_method;
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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "crop_id", referencedColumnName = "crop_id")
    private Crop crop;
}
