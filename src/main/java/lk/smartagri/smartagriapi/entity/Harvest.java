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
    private String harvest_method;
    private String MethodDesc;

    @OneToMany(mappedBy = "harvest", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Harvest_Detail> harvest_detail;
}
