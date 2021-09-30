package nl.koenm.springtutfull.service;

import nl.koenm.springtutfull.entity.Department;
import nl.koenm.springtutfull.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentId(2L)
                .departmentName("KBS")
                .departmentAddress("NoordeIJ en Zeedijk 12")
                .departmentCode("DK-02")
//                .departmentEmail("kbs@diekbv.nl")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("KBS")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data Based on Valid Department Name")
//    @Disabled
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "KBS";
        Department found = departmentService.fetchDepartmentByName(departmentName);


        assertEquals(departmentName, found.getDepartmentName());
    }
}