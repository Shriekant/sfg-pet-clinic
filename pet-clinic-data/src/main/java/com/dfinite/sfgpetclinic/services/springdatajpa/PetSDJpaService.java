package com.dfinite.sfgpetclinic.services.springdatajpa;

import com.dfinite.sfgpetclinic.model.Pet;
import com.dfinite.sfgpetclinic.repositories.PetRepository;
import com.dfinite.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajap")
public class PetSDJpaService implements PetService {

    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet Save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
            petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
            petRepository.deleteById(aLong);
    }
}
