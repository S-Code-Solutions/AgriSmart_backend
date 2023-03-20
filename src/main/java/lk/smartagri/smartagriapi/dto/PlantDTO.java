package lk.smartagri.smartagriapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlantDTO {
    @Id
    private String plantMethod;
    private String MethodDesc;
//    private List<Plant_DetailDTO> plantDetailDTO;
}
