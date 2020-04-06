package com.dfinite.sfgpetclinic.services;

import com.dfinite.sfgpetclinic.model.Speciality;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public interface SpecialityService extends CrudService<Speciality,Long> {
}
