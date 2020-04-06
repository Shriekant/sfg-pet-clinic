package com.dfinite.sfgpetclinic.services.map;

import com.dfinite.sfgpetclinic.model.Speciality;
import com.dfinite.sfgpetclinic.services.CrudService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialitiesMapService extends AbstractMapService<Speciality,Long> implements CrudService<Speciality,Long> {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
            super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {

        super.delete(object);
    }

    @Override
    public Speciality Save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id)
    {
        return super.findById(id);
    }
}
