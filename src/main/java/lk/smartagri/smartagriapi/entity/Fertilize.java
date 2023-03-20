package lk.smartagri.smartagriapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "fertilize")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fertilize {
    @Id
    private String fertilize_name;
    private String fertilizer_type;

    @OneToMany(mappedBy = "fertilize", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Fertilize_Detail> fertilize_detail;

}
