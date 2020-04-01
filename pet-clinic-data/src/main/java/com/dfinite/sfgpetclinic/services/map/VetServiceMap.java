package com.dfinite.sfgpetclinic.services.map;

import com.dfinite.sfgpetclinic.model.Vet;
import com.dfinite.sfgpetclinic.services.CrudService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet,Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);

    }

    @Override
    public void delete(Vet object) {

        super.delete(object);
    }

    @Override
    public Vet Save(Vet object) {
        return save(object.getId(),object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
