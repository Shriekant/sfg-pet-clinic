package com.dfinite.sfgpetclinic.bootstrap;

import com.dfinite.sfgpetclinic.model.*;
import com.dfinite.sfgpetclinic.services.OwnerService;
import com.dfinite.sfgpetclinic.services.PetTypeService;
import com.dfinite.sfgpetclinic.services.SpecialityService;
import com.dfinite.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoder implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;


    public DataLoder(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService)
    {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService=petTypeService;
        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if(count==0) {

            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("jocky");
        PetType savedDogType = petTypeService.Save(dog);

        PetType cat = new PetType();
        cat.setName("miya");
        PetType savedCatType = petTypeService.Save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.Save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("surgery");
        Speciality savedSurgery = specialityService.Save(surgery);


        Speciality dentistry = new Speciality();
        radiology.setDescription("dentistry");
        Speciality savedDentistry = specialityService.Save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("shrikant");
        owner1.setLastname("Kundur");
        owner1.setAddress("123 baker street");
        owner1.setCity("sydney");
        owner1.setTelephone("123456789");

        Pet shrikantsPet = new Pet();
        shrikantsPet.setPetType(savedDogType);
        shrikantsPet.setOwner(owner1);
        shrikantsPet.setBirthDate(LocalDate.now());
        shrikantsPet.setName("rosco");


        owner1.getPets().add(shrikantsPet);
        ownerService.Save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mike");
        owner2.setLastname("Ross");
        owner2.setAddress("westeria lane");
        owner2.setCity("NewYork");
        owner2.setTelephone("789956423");

        Pet miekspet = new Pet();
        miekspet.setName("husky");
        miekspet.setOwner(owner2);
        miekspet.setPetType(savedCatType);
        miekspet.setBirthDate(LocalDate.now());
//        owner2.getPets().add(miekspet);

        ownerService.Save(owner2);

        System.out.println("Loded owner");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastname("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.Save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Raju");
        vet2.setLastname("Shrivastav");
        vet2.getSpecialities().add(savedSurgery);
        vetService.Save(vet2);

        System.out.println("Loded Vet");
    }
}
