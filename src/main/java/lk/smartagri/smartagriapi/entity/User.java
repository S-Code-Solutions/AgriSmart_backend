package lk.smartagri.smartagriapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "user")
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

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Crop> crop;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private List<auction> auction;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Finance> finance;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private List<forum> forum;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private List<market> market;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private List<comment> comment;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Order> orders;

}