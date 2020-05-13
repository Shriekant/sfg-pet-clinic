package com.dfinite.sfgpetclinic.formatters;

import com.dfinite.sfgpetclinic.model.PetType;
import com.dfinite.sfgpetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class PetTypeFormatters implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatters(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findtypes = petTypeService.findAll();

        for(PetType types : findtypes)
            if(types.getName().equals(text)) {
                return types;
            }
        throw new ParseException("type not found:" +text,0);
    }

    @Override
    public String print(PetType petType, Locale locale) {
                return petType.getName();
    }
}
