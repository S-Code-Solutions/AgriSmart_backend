package lk.smartagri.smartagriapi.repository;

import lk.smartagri.smartagriapi.entity.Crop;
import lk.smartagri.smartagriapi.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PlantingRepository extends JpaRepository<Plant,String> {

    boolean existsByPlantMethod(String plantMethod);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO plant(plant_method,method_desc) VALUES (?,?)", nativeQuery = true)
    void addPlantRecord(String plantMethod,
                        String MethodDesc
    );

    @Query(value = "SELECT * FROM plant where username = ?1 ",nativeQuery = true)
    List<Plant> findAllByUserName(String username);
}
