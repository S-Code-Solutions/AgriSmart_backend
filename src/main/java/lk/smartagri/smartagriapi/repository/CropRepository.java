package lk.smartagri.smartagriapi.repository;

import lk.smartagri.smartagriapi.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface CropRepository extends JpaRepository<Crop,Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Crop(crop_id,crop_name,crop_variety,planting_date,harvest_date,expected_yield,soil_type,fertilizer_control,pesticide_type,crop_status,cost,location,userwid) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)" ,nativeQuery = true)
    void addCropRecorde(int crop_id,
                           String crop_name,
                           String crop_variety,
                        LocalDate planting_date,
                        LocalDate harvest_date,
                        double expected_yield,
                           String soil_type,
                           String fertilizer_control,
                           String pesticide_type,
                           String crop_status,
                        double cost,
                        String location,String userId);

    @Query(value = "SELECT * FROM Crop where userwid = ?1 ",nativeQuery = true)
    List<Crop> findAllByUserName(String username);
}
