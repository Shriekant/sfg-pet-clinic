package com.dfinite.sfgpetclinic.services;


import com.dfinite.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VatService {

    Vet findById(Long Id);
    Vet Save(Vet vet);
    Set<Vet> findAll();
}
