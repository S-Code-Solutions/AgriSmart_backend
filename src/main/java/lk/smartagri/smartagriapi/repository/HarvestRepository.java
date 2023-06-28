package lk.smartagri.smartagriapi.repository;

import lk.smartagri.smartagriapi.entity.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HarvestRepository extends JpaRepository<Harvest, Long> {

    @Query(value = "SELECT h.* FROM harvest h " +
            "INNER JOIN crop c ON h.crop_id = c.crop_id " +
            "INNER JOIN user u ON c.username = u.username " +
            "WHERE u.username = ?1", nativeQuery = true)
    List<Harvest> findAllByUserName(String username);
}
