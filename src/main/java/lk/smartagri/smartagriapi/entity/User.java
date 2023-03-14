package lk.smartagri.smartagriapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "systemuser")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    private String password;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "roleCode", referencedColumnName = "UserRoleCode")
    private UserRole roleCode;

    private String address;
    @Id
    private String username;
    private String status;
    private String phoneNo1;
    private String phoneNo2;
    private String idPhoto;
    private String remarks;
    private String email;
    private String name;



}