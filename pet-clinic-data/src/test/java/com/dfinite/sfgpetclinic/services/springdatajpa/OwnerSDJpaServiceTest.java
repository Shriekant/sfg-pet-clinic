package com.dfinite.sfgpetclinic.services.springdatajpa;

import com.dfinite.sfgpetclinic.model.Owner;
import com.dfinite.sfgpetclinic.repositories.OwnerRepository;
import com.dfinite.sfgpetclinic.repositories.PetRepository;
import com.dfinite.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME="Smith";

     @Mock
     OwnerRepository ownerRepository;

     @Mock
     PetRepository petRepository;

     @Mock
     PetTypeRepository petTypeRepository;

     @InjectMocks
     OwnerSDJpaService ownerSDJpaService;

     Owner returnOwner;

    @BeforeEach
    void setUp() {

        returnOwner= Owner.builder().id(1l).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith=ownerSDJpaService.findByLastName(LAST_NAME);

        Assertions.assertEquals(LAST_NAME,smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {

        Set<Owner> returnOwnerSet = new HashSet<>();

        returnOwnerSet.add(Owner.builder().id(1l).build());
        returnOwnerSet.add(Owner.builder().id(2l).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2,owners.size());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = ownerSDJpaService.findById(1l);
        assertNotNull(owner);
    }

    @Test
    void save() {

        Owner ownerToSave = Owner.builder().id(1l).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerSDJpaService.Save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());


    }

    @Test
    void delete() {

        ownerSDJpaService.delete(returnOwner);

        verify(ownerRepository,times(1)).delete(any());

    }

    @Test
    void deleteById() {

        ownerSDJpaService.deleteById(1l);

        verify(ownerRepository,times(1)).deleteById(anyLong());
    }
}