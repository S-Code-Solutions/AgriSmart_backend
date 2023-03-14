package lk.smartagri.smartagriapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserOTPDTO {
    @Id
    private int id;
    private String useremail;
    private String otp;
}
