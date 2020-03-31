package com.dfinite.sfgpetclinic.services;

import com.dfinite.sfgpetclinic.model.Owner;
import com.dfinite.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long Id);

    Pet Save(Owner owner);

    Set<Pet> findAll();
}
