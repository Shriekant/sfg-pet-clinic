package com.dfinite.sfgpetclinic.services.springdatajpa;

import com.dfinite.sfgpetclinic.model.Owner;
import com.dfinite.sfgpetclinic.repositories.OwnerRepository;
import com.dfinite.sfgpetclinic.repositories.PetRepository;
import com.dfinite.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

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

        returnOwner= Owner.builder().telephone("4512").build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        //Owner smith=ownerSDJpaService.findByLastName();
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}