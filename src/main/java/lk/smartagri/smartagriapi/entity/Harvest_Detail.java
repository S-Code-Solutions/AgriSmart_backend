package lk.smartagri.smartagriapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "harvest_detail")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Harvest_Detail {

    @Id
    private String harvest_detail_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "harvest_method", referencedColumnName = "harvest_method")
    private Harvest harvest;

    private String harvesting_equipment;
    private String labor_requirement;
    private String storage_requirement;
    private String harvest_quality;
    private String harvest_cost;
    private String harvest_waste;
    private LocalDate harvesting_date;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "crop_id", referencedColumnName = "crop_id")
    private Crop crop_id;
}
