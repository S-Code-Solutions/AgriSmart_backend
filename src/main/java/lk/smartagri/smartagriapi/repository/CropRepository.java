package lk.smartagri.smartagriapi.repository;

import lk.smartagri.smartagriapi.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface CropRepository extends JpaRepository<Crop,Integer> {

//    @Query(value = "SELECT planting_id FROM crop ORDER BY planting_id DESC LIMIT 1;", nativeQuery = true)
//    String getLastOrderId();
//
//    @Query(value = "SELECT planting_id FROM crop ORDER BY planting_id DESC LIMIT 1;", nativeQuery = true)
//    String getLastOrderId();
//
//    @Query(value = "SELECT planting_id FROM crop ORDER BY planting_id DESC LIMIT 1;", nativeQuery = true)
//    String getLastOrderId();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO crop(crop_id,crop_name,crop_variety,imageurl,crop_status,username) VALUES (?,?,?,?,?,?)", nativeQuery = true)
    void addCropRecorde(int crop_id,
                        String crop_name,
                        String crop_variety,
                        String imageURL,
                        String crop_status,
                        String username
    );

    @Query(value = "SELECT * FROM crop where username = ?1 ",nativeQuery = true)
    List<Crop> findAllByUserName(String username);


//    @Query(value = "SELECT * FROM crop where crop_name =?1",nativeQuery = true)
//    boolean existByCname(String crop_name);

//    @Query(value = "SELECT * FROM crop where crop_name =?1",nativeQuery = true)
//    boolean existByCname(String crop_name);

    @Query(value =  "SELECT EXISTS(SELECT * FROM crop WHERE crop_name = ?1)", nativeQuery = true)
    boolean existsByCropName(String crop_name);

    @Query(value = "SELECT * FROM crop WHERE crop_name LIKE %?1%", nativeQuery = true)
    List<Crop> findByNameLike(String crop_name);

}
