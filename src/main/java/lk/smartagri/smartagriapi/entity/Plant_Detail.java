package lk.smartagri.smartagriapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "plant_detail")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plant_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long plant_detail_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "plantMethod", referencedColumnName = "plantMethod")
    private Plant plant;

    private String planting_location;
    private String planting_density;
    private String seeding_rate;
    private String seeding_depth;
    private String soil_preparation;
    private LocalDate planting_date;
    private int water_duration;
    private String message;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "crop_id", referencedColumnName = "crop_id")
    private Crop crop_id;
}
