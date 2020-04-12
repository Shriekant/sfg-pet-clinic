package com.dfinite.sfgpetclinic.services.map;

import com.dfinite.sfgpetclinic.model.Visit;
import com.dfinite.sfgpetclinic.services.PetService;
import com.dfinite.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {

    private final PetService petService;

    public VisitMapService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Set<Visit> findAll()
    {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
            super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit Save(Visit visit)
    {
        if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId()==null
        || visit.getPet().getId()== null)
        {
            throw new RuntimeException("Invalid visit");
        }

        return super.save(visit);
    }

    @Override
    public Visit findById(Long id)
    {
        return super.findById(id);
    }
}
