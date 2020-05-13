package com.dfinite.sfgpetclinic.controllers;

import com.dfinite.sfgpetclinic.model.Pet;
import com.dfinite.sfgpetclinic.model.Visit;
import com.dfinite.sfgpetclinic.services.PetService;
import com.dfinite.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setDisallowedField(WebDataBinder dataBinder)
    {
        dataBinder.setDisallowedFields("id");

    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable ("petId") Long petId, Model model)
    {
        Pet pet = petService.findById(petId);
        model.addAttribute("pet",pet);

        Visit visit = new Visit();
        pet.getVisitSet().add(visit);
        visit.setPet(pet);

        return visit;
    }

    //spring mvc calls method loadPetWithVisit(...) before initNewVisitForm is called
    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") Long petId,Model model)
    {
        return "pets/createOrUpdateVisitForm";
    }

    @PostMapping("owners/*/pets/{petId}/visits/new")
    public String processVisitForm(@Valid Visit visit, BindingResult result,Model model)
    {
        if(result.hasErrors())
        {
            return "pets/createOrUpdateVisitForm";
        }
        else
        {
            visitService.Save(visit);

            return "redirect:/owners/{ownerId}";
        }
    }
}
