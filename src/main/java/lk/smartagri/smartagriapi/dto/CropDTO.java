package lk.smartagri.smartagriapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDTO {
    @Id
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
    private String userId;
}
