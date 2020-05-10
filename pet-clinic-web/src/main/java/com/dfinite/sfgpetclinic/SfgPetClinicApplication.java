package com.dfinite.sfgpetclinic;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootApplication
public class SfgPetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfgPetClinicApplication.class, args);


    }


}
