package com.dfinite.sfgpetclinic.services;

import com.dfinite.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long Id);

    Owner Save(Owner owner);

    Set<Owner> findAll();

}
