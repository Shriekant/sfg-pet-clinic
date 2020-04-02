package com.dfinite.sfgpetclinic.services.map;

import com.dfinite.sfgpetclinic.model.Vet;
import com.dfinite.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService
{
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
