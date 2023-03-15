package lk.smartagri.smartagriapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "planting")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Planting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long planting_id;
    private String planting_method;
    private String crop_name;
    private String planting_location;
    private String planting_density;
    private String seeding_rate;
    private String seeding_depth;
    private String soil_preparation;
    private String planting_date;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "crop_id", referencedColumnName = "crop_id")
    private Crop crop;
}
