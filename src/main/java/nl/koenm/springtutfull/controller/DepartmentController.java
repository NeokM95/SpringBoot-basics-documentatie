package nl.koenm.springtutfull.controller;

import nl.koenm.springtutfull.entity.Department;
import nl.koenm.springtutfull.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    /**
     * Post Methodes:
     */

    @PostMapping("/departments")
    public Department saveDepartment(
            @Valid
            @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    /**
     * Get Methodes:
     */

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Inside fetchDepartmentById of DepartmentController");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByDepartmentName(@PathVariable("name") String departmentName) {
        LOGGER.info("Inside fetchDepartmentByDepartmentName of DepartmentController");
        return departmentService.fetchDepartmentByName(departmentName);
    }

    /**
     * Update Methodes:
     */

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    /**
     * Delete Methodes:
     */

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!";
    }


}
