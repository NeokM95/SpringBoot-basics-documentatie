package nl.koenm.springtutfull.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloKoen(){
        return "Hello, my name is Koen!!";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return "Hello, " + name + "!";
    }

}
