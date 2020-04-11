package com.dfinite.sfgpetclinic.repositories;

import com.dfinite.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
