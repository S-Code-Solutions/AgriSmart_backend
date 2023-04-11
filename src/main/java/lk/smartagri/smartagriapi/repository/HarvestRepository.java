package lk.smartagri.smartagriapi.repository;

import lk.smartagri.smartagriapi.entity.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HarvestRepository extends JpaRepository<Harvest, Long> {

    @Query(value = "SELECT EXISTS(SELECT * FROM harvest WHERE harvest_id = ?1)", nativeQuery = true)
    boolean exitBHarvest_id(Long harvest_id);

    @Query(value = "SELECT * FROM harvest where username = ?1 ",nativeQuery = true)
    List<Harvest> findAllByUserName(String username);
}
