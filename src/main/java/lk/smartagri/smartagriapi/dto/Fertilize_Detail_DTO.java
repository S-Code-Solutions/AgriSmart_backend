package lk.smartagri.smartagriapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.smartagri.smartagriapi.entity.Crop;
import lk.smartagri.smartagriapi.entity.Fertilize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fertilize_Detail_DTO {
    @Id
    private String fertilize_detail_id;
    private String fertilize_name;
    private String fertilizer_app_method;
    private String fertilizer_app_fre;
    private String application_rate;
    private String fertilizer_placement;
    private String application_timing;
    private String fertigation;
    private LocalDate fertlizing_date;
    private int crop_id;
}
