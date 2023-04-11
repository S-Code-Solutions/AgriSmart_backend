package lk.smartagri.smartagriapi.repository;

import lk.smartagri.smartagriapi.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface PlantingRepository extends JpaRepository<Plant,Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO plant(plant_id,plant_method, planting_date, planting_density, planting_location, seeding_depth, seeding_rate, soil_preparation, water_duration, message, crop_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)", nativeQuery = true)
    void addPLantRecord(int plant_id,
                        String plant_method,
                        LocalDate planting_date,
                        String planting_density,
                        String planting_location,
                        String seeding_depth,
                        String seeding_rate,
                        String soil_preparation,
                        int water_duration,
                        String message,
                        int crop_id
    );

    @Query(value = "SELECT p.* FROM plant p " +
            "INNER JOIN crop c ON p.crop_id = c.crop_id " +
            "INNER JOIN user u ON c.username = u.username " +
            "WHERE u.username = ?1", nativeQuery = true)
    List<Plant> findAllByUserName(String username);
}
