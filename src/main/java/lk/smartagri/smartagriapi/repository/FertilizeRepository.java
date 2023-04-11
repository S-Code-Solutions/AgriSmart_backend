package lk.smartagri.smartagriapi.repository;

import lk.smartagri.smartagriapi.entity.Fertilize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FertilizeRepository extends JpaRepository<Fertilize, Long> {

    @Query(value = "SELECT EXISTS(SELECT * FROM fertilize WHERE fertilize_id = ?1)", nativeQuery = true)
    boolean existBFertilize_id(Long fertilize_id);

    @Query(value = "SELECT * FROM fertilize where username = ?1 ",nativeQuery = true)
    List<Fertilize> findAllByUserName(String username);
}
