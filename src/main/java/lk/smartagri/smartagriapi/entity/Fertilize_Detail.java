package lk.smartagri.smartagriapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fertilize_detail")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fertilize_Detail {

    @Id
    private String fertilize_detail_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fertilize_name", referencedColumnName = "fertilize_name")
    private Fertilize fertilize;

    private String fertilizer_app_method;
    private String fertilizer_app_fre;
    private String application_rate;
    private String fertilizer_placement;
    private String application_timing;
    private String fertigation;
    private LocalDate fertlizing_date;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "crop_id", referencedColumnName = "crop_id")
    private Crop crop_id;
}
