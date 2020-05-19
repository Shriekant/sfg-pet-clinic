package com.dfinite.sfgpetclinic.services.map;

import com.dfinite.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class PetServiceMapTest {

    private PetServiceMap petServiceMap;

    private final Long petId=1L;

    @BeforeEach
    void Setup()
    {
        petServiceMap = new PetServiceMap();
        petServiceMap.save(Pet.builder().id(petId).build());
    }

    @Test
    void finaAll()
    {
        Set<Pet> petSet = petServiceMap.findAll();

        Assertions.assertEquals(1,petSet.size());
    }

    @Test
    void deleteByIdTest()
    {
        petServiceMap.deleteById(petId);

        Assertions.assertEquals(0,petServiceMap.findAll().size());

    }

    @Test
    void TestSavePet()
    {
        Long id=2L;

        Pet pet = Pet.builder().id(id).build();
        Pet SavedPet=petServiceMap.save(pet);

        Assertions.assertEquals(id,SavedPet.getId());
    }

    @Test
    void deleteBYWrongId()
    {
        Pet pet = Pet.builder().id(5L).build();

        petServiceMap.delete(pet);

        Assertions.assertEquals(1,petServiceMap.findAll().size());

    }

    @Test
    void deleteWithNullId()
    {
        Pet pet = Pet.builder().build();

        petServiceMap.delete(pet);

        Assertions.assertEquals(1,petServiceMap.findAll().size());
    }

    void deleteNull()
    {
        petServiceMap.delete(null);

        Assertions.assertEquals(1,petServiceMap.findAll().size());
    }

    @Test
    void deletePet()
    {
        petServiceMap.delete(petServiceMap.findById(petId));

        Assertions.assertEquals(0,petServiceMap.findAll().size());
    }
}
