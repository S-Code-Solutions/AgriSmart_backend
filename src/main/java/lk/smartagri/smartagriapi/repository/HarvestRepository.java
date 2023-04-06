package lk.smartagri.smartagriapi.repository;

import lk.smartagri.smartagriapi.entity.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestRepository extends JpaRepository<Harvest, Long> {
    boolean existByHarvest_id(long harvestId);
}
