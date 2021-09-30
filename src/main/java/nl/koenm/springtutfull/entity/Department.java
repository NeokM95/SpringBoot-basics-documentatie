package nl.koenm.springtutfull.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@EqualsAndHashCode
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please Add Department Name")
    private String departmentName;

    @NotBlank(message = "Please Add Department Address")
    private String departmentAddress;

    @NotBlank(message = "Please Add Department Code")
    private String departmentCode;


//    Waarom zijn Email en Custom Equals en HashCode de boosdoener om Controller tests te laten slagen terwijl mijn request wel gewoon doorkomt via postman?



//    @NotBlank(message = "Please Add Email")
//    @Email(message = "Email should be valid")
//    private String departmentEmail;


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Department)) return false;
//
//        Department that = (Department) o;
//
//        if (getDepartmentId().equals(that.getDepartmentId())) return true;
//        if (getDepartmentName().equals(that.getDepartmentName())) return true;
//        return getDepartmentCode().equals(that.getDepartmentCode());
//    }
//
//    @Override
//    public int hashCode() {
//        return 0;
//    }
}

