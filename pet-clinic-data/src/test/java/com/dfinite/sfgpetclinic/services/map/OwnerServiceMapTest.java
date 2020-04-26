package com.dfinite.sfgpetclinic.services.map;

import com.dfinite.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long ownerId =1L;
    final String telephoneNo="7412";
    final String lastName ="smith";

    @BeforeEach
    void setUp() {

        ownerServiceMap= new OwnerServiceMap(new PetServiceMap(),new PetTypeMapService());

      //  ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());

    }

    @Test
    void findAll() {

        Owner owner = new Owner();
        owner.setId(1L);
        ownerServiceMap.save(owner);

        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1,ownerSet.size());
    }

    @Test
    void findById() {

        Owner owner = new Owner();
        owner.setId(ownerId);
        ownerServiceMap.save(owner);
        ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());

    }

    @Test
    void save() {
        Long Ownerid=2L;
        Owner owner = new Owner();
        owner.setId(Ownerid);
        //Long id = 2L;
     //   Owner owner2 = Owner.builder()
        Owner saveOwner = ownerServiceMap.save(owner);

        assertEquals(Ownerid, saveOwner.getId());
    }

    @Test
    void saveNoId()
    {

    }

    @Test
    void delete() {

        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {

        Owner smith = ownerServiceMap.findByLastName(lastName);

        assertNotNull(smith);

        assertEquals(ownerId,smith.getId());

    }
}