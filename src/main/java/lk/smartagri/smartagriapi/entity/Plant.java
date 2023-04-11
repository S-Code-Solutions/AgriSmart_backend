package lk.smartagri.smartagriapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "plant")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "crop_id", referencedColumnName = "crop_id")
    private Crop crop_id;

//    @Id
//    private String plantMethod;
//    private String MethodDesc;
//
//    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private List<Plant_Detail> plant_detail;

}
