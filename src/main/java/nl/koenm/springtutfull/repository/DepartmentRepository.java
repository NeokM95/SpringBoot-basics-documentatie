package nl.koenm.springtutfull.repository;

import nl.koenm.springtutfull.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentNameIgnoreCase(String departmentName);
}
