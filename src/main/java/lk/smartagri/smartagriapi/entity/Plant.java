package lk.smartagri.smartagriapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "plant")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plant {
    @Id
    private String plantMethod;
    private String MethodDesc;

    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Plant_Detail> plant_detail;

}
