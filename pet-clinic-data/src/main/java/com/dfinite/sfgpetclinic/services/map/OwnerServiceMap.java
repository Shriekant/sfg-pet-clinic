package com.dfinite.sfgpetclinic.services.map;

import com.dfinite.sfgpetclinic.model.Owner;
import com.dfinite.sfgpetclinic.model.Pet;
import com.dfinite.sfgpetclinic.services.OwnerService;
import com.dfinite.sfgpetclinic.services.PetService;
import com.dfinite.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService{

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

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

        if(object != null){
            if(object.getPets() != null){
            object.getPets().forEach(pet ->{
                if (pet.getPetType() != null){
                    if( pet.getPetType().getId() == null){
                        pet.setPetType(petTypeService.Save(pet.getPetType()));
                    }
                }else {
                    throw new RuntimeException("Pet type is required");
                }
                if(pet.getId() ==null){
                    Pet SavedPet= petService.Save(pet);
                    pet.setId(SavedPet.getId());
                }
            });
            }
            return super.save(object);
        }else{
            return null;
        }
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
