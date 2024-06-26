package org.example.helloeks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloEksApplication {
    @GetMapping("/greeting")
    public String message(){
        return "Hello jam jam EKS";
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloEksApplication.class, args);
    }

}
