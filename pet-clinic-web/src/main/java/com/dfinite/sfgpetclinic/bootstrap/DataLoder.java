package com.dfinite.sfgpetclinic.bootstrap;

import com.dfinite.sfgpetclinic.model.Owner;
import com.dfinite.sfgpetclinic.model.Pet;
import com.dfinite.sfgpetclinic.model.PetType;
import com.dfinite.sfgpetclinic.model.Vet;
import com.dfinite.sfgpetclinic.services.OwnerService;
import com.dfinite.sfgpetclinic.services.PetTypeService;
import com.dfinite.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoder implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoder(OwnerService ownerService, VetService vetService, PetTypeService petTypeService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService=petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("jocky");
        PetType savedDogType = petTypeService.Save(dog);

        PetType cat = new PetType();
        cat.setName("miya");
        PetType savedCatType = petTypeService.Save(cat);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("shrikant");
        owner1.setLastname("Kundur");
        owner1.setAddress("123 baker street");
        owner1.setCity("sydney");
        owner1.setTelephone("123456789");

        Pet shrikantsPet = new Pet();
        shrikantsPet.setPetType(savedDogType);
        shrikantsPet.setBirthDate(LocalDate.now());
        //shrikantsPet.setName("rosco");

        owner1.getPets().add(shrikantsPet);

        ownerService.Save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mike");
        owner2.setLastname("Ross");
        owner2.setAddress("westeria lane");
        owner2.setCity("NewYork");
        owner2.setTelephone("789956423");

        Pet miekspet = new Pet();
        //miekspet.setName("husky");
        miekspet.setPetType(savedCatType);
        miekspet.setBirthDate(LocalDate.now());

        owner2.getPets().add(miekspet);

        ownerService.Save(owner2);

        System.out.println("Loded owner");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastname("Axe");
        vetService.Save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Raju");
        vet2.setLastname("Shrivastav");
        vetService.Save(vet2);

        System.out.println("Loded Vet");




    }
}
