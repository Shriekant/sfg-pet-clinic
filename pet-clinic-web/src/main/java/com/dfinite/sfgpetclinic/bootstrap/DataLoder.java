package com.dfinite.sfgpetclinic.bootstrap;

import com.dfinite.sfgpetclinic.model.Owner;
import com.dfinite.sfgpetclinic.model.Vet;
import com.dfinite.sfgpetclinic.services.OwnerService;
import com.dfinite.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoder implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoder(OwnerService ownerService, VetService vetService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("shrikant");
        owner1.setLastname("Kundur");

        ownerService.Save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mike");
        owner2.setLastname("Ross");

        ownerService.Save(owner2);

        System.out.println("Loded owner");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastname("Axe");
        vetService.Save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Raju");
        vet2.setLastname("Shrivastav");
        vetService.Save(vet2);

        System.out.println("Loded Vet");




    }
}
