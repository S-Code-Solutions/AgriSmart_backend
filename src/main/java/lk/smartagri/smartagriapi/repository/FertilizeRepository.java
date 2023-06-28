package lk.smartagri.smartagriapi.repository;

import lk.smartagri.smartagriapi.entity.Fertilize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FertilizeRepository extends JpaRepository<Fertilize, Long> {

//    @Query(value = "SELECT EXISTS(SELECT * FROM fertilize WHERE fertilize_id = ?1)", nativeQuery = true)
//    boolean existsByFertilize_id(Long fertilize_id);

    @Query(value = "SELECT f.* FROM fertilize f " +
            "INNER JOIN crop c ON f.crop_id = c.crop_id " +
            "INNER JOIN user u ON c.username = u.username " +
            "WHERE u.username = ?1", nativeQuery = true)
    List<Fertilize> findAllByUserName(String username);
}
