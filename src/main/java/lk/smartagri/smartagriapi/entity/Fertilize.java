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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fertilize_id;
    private String fertilize_name;
    private String fertilizer_type;
    private String fertilizer_app_method;
    private String fertilizer_app_fre;
    private String application_rate;
    private String fertilizer_placement;
    private String application_timing;
    private String fertigation;
    private LocalDate fertlizing_date;
    private String message;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "crop_id", referencedColumnName = "crop_id")
    private Crop crop_id;
}
