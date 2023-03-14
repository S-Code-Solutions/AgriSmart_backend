package lk.smartagri.smartagriapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "userrole")
public class UserRole {
    @Id
    private int UserRoleCode;
    private String UserRole;
}
