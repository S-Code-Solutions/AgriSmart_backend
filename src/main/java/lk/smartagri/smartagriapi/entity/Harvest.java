package lk.smartagri.smartagriapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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
    private int harvest_cost;
    private String harvest_waste;
    private LocalDate harvesting_date;
    private String message;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "crop_id", referencedColumnName = "crop_id")
    private Crop crop_id;

}
