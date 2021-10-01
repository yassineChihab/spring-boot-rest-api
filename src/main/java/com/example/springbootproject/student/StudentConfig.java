package com.example.springbootproject.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args->{
              Student yassine=  new Student(
                        1L,
                        "yassine",
                        "chihabyassine@gùaom.com",
                        LocalDate.of(1999,9,25)

                );
            Student chihab=  new Student(
                    2L,
                    "chihab",
                    "chihabyassine@gùaom.com",
                    LocalDate.of(199,9,25)

            );
            repository.saveAll(
                    List.of(yassine,chihab)
            );
        };
    }
}
