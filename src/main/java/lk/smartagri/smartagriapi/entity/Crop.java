package lk.smartagri.smartagriapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "crop")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Crop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long crop_id;
    private String crop_name;
    private String crop_variety;
    private LocalDate planting_date;
    private LocalDate harvest_date;
    private double expected_yield;
    private String soil_type;
    private String fertilizer_control;
    private String pesticide_type;
    private String crop_status;
    private double cost;
    private String location;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userWId", referencedColumnName = "username")
    private User userId;
}
