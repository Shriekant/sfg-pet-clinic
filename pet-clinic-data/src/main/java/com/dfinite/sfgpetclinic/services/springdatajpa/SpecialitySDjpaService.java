package com.dfinite.sfgpetclinic.services.springdatajpa;

import com.dfinite.sfgpetclinic.model.Speciality;
import com.dfinite.sfgpetclinic.repositories.SpecialityRepository;
import com.dfinite.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajap")
public class SpecialitySDjpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDjpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality Save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
            specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
            specialityRepository.deleteById(aLong);
    }
}
