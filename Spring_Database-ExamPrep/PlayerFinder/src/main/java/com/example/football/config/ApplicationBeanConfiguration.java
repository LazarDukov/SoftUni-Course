package com.example.football.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;


@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public Gson createGson() {
        final String dateFormat = "dd/MM/yyyy";

        return new GsonBuilder().setDateFormat(dateFormat).create();

    }

    @Bean
    public ModelMapper createModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Validator createValidator(){
        return Validation.buildDefaultValidatorFactory().getValidator();
    }
}
