package lk.smartagri.smartagriapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "userotp")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserOTP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String useremail;
    private String otp;
}
