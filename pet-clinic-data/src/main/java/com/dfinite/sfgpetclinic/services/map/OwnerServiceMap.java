package com.dfinite.sfgpetclinic.services.map;

import com.dfinite.sfgpetclinic.model.Owner;
import com.dfinite.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService{

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner Save(Owner object) {
        return super.save(object);
    }

    @Override
    public void delete(Owner object) {

            super.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {

        super.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
