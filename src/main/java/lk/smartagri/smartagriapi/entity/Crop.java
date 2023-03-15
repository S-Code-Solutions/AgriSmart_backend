package lk.smartagri.smartagriapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "crop")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Crop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int crop_id;
    private String crop_name;
    private String crop_variety;
    private String soil_type;
    private String pesticide_type;
    private String crop_status;

    @OneToMany(mappedBy = "crop", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Planting> plantings;

    @OneToMany(mappedBy = "crop", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Fertilize> fertilizers;

    @OneToMany(mappedBy = "crop", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Harvest> harvests;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;
}
