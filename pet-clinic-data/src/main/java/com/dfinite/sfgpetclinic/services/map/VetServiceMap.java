package com.dfinite.sfgpetclinic.services.map;

import com.dfinite.sfgpetclinic.model.Speciality;
import com.dfinite.sfgpetclinic.model.Vet;
import com.dfinite.sfgpetclinic.services.SpecialityService;
import com.dfinite.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService
{
    private final SpecialityService specialityService;


    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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

        if(object.getSpecialities().size()>0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality =specialityService.Save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
