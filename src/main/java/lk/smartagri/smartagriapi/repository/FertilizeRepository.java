package lk.smartagri.smartagriapi.repository;

import lk.smartagri.smartagriapi.entity.Fertilize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FertilizeRepository extends JpaRepository<Fertilize, Long> {

    boolean existsByFertilize_id(long fertilizeId);

    @Query(value = "SELECT * FROM fertilize where username = ?1 ",nativeQuery = true)
    List<Fertilize> findAllByUserName(String username);
}
