package lk.smartagri.smartagriapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "crop",uniqueConstraints = {@UniqueConstraint(columnNames = {"crop_variety"})})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Crop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int crop_id;
    private String crop_name;
    @Column(name = "crop_variety")
    private String crop_variety;
    private String imageURL;
    private String crop_status;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
}
