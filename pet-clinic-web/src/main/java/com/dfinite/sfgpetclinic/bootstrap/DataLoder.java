package com.dfinite.sfgpetclinic.bootstrap;

import com.dfinite.sfgpetclinic.model.Owner;
import com.dfinite.sfgpetclinic.model.Vet;
import com.dfinite.sfgpetclinic.services.OwnerService;
import com.dfinite.sfgpetclinic.services.VetService;
import com.dfinite.sfgpetclinic.services.map.OwnerServiceMap;
import com.dfinite.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoder implements CommandLineRunner {

    private static OwnerService ownerService;
    private static VetService vetService;

    public DataLoder()
    {
        ownerService=new OwnerServiceMap();
        vetService=new VetServiceMap();
    }
    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("shrikant");
        owner1.setLastname("Kundur");

        ownerService.Save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Mike");
        owner1.setLastname("Ross");

        ownerService.Save(owner2);

        System.out.println("Loded owner");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastname("Axe");
        vetService.Save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Raju");
        vet2.setLastname("Shrivastav");
        vetService.Save(vet2);

        System.out.println("Loded Vet");




    }
}
