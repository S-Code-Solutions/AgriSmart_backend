package lk.smartagri.smartagriapi.repository;

import lk.smartagri.smartagriapi.entity.Plant_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface PlantDetailRepository extends JpaRepository<Plant_Detail,Long> {

//    boolean existsByPlant_detail_id(Long plant_detail_id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO plant_detail(plant_detail_id,plantMethod,planting_location,planting_density,seeding_rate,seeding_depth,soil_preparation,planting_date,water_duration,message,crop_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)", nativeQuery = true)
    void addPlantDRecord(
                        long plant_detail_id,
                        String plantMethod,
                        String planting_location,
                        String planting_density,
                        String seeding_rate,
                        String seeding_depth,
                        String soil_preparation,
                        LocalDate planting_date,
                        int water_duration,
                        String message,
                        int crop_id
    );

//    @Query("SELECT plant_detail FROM User user "
//            + "JOIN user.crops crop "
//            + "JOIN crop.plant_detail planting "
//            + "WHERE user.userId = :userId")
//    List<Plant_Detail> findAllByUserId(Long userId);

    @Query("SELECT pd FROM Plant_Detail pd JOIN pd.crop_id c JOIN c.user u WHERE u.username = :username")
    static List<Plant_Detail> findAllByUserName(String username) {
        return null;
    }


}
