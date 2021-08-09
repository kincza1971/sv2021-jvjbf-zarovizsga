package org.training360.finalexam;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.training360.finalexam.exceptions.EntityNotFoundExceptionHandler;

@SpringBootApplication
public class FinalExamApplication {

    @Bean
    EntityNotFoundExceptionHandler handler() {
        return new EntityNotFoundExceptionHandler();
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }


    public static void main(String[] args) {
        SpringApplication.run(FinalExamApplication.class, args);
    }

}
