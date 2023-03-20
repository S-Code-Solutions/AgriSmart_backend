package lk.smartagri.smartagriapi.repository;

import lk.smartagri.smartagriapi.entity.Crop;
import lk.smartagri.smartagriapi.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantingRepository extends JpaRepository<Plant,Integer> {
}
