package nl.koenm.springtutfull;

import nl.koenm.springtutfull.entity.Department;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringTutFullApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringTutFullApplication.class, args);


//        Department dep1 = new Department( 1L,"AJAX", "Langedijk 13", "AJA", "AJAX@ajax.com" );
//
//        Department dep2 = new Department( 2L,"AZ", "Langedijk 13", "AZ", "AJAX@ajax.com" );
//
//        Map<Department, String> map = new HashMap<>();
//        map.put(dep1, "ajax");
//        map.put(dep2, "ajax");
//
//        System.out.println(map.size());


    }


}
