package lk.smartagri.smartagriapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FertilizeDTO {
    @Id
    private String fertilize_name;
    private String fertilizer_type;

    private List<Fertilize_Detail_DTO> fertilize_detail;

}
