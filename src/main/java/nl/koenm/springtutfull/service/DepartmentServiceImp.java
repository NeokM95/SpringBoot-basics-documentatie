package nl.koenm.springtutfull.service;

import nl.koenm.springtutfull.entity.Department;
import nl.koenm.springtutfull.error.DepartmentNotFoundException;
import nl.koenm.springtutfull.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    /** Put Methodes: */

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    /** Get Methodes: */

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
       Optional<Department> department = departmentRepository.findById(departmentId);

       if(department.isEmpty()){
           throw new DepartmentNotFoundException("Department Not Available");
       }

       return department.get();
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

    /** Update Methodes: */

    @Override
    public Department updateDepartment(Long departmentId, Department department) {

        Department depDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentName(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentName(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);

    }

    /** Delete Methodes: */

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }


}
