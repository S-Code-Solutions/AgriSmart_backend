package lk.smartagri.smartagriapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FertilizeDTO {
    @Id
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
    private int crop_id;

}
