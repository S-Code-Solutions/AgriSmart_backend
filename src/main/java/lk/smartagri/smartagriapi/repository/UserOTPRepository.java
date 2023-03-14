package lk.smartagri.smartagriapi.repository;

import lk.smartagri.smartagriapi.entity.UserOTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserOTPRepository extends JpaRepository<UserOTP,Integer> {

    @Query(value = "SELECT otp FROM userotp WHERE useremail = ?1",nativeQuery = true)
    String findByEmail(String email);

    boolean existsByUseremail(String email);

    @Modifying
    @Query(value = "Update userotp SET otp = ?1 where useremail=?2",nativeQuery = true)
    void updateuserotp(String otp, String email);
}
