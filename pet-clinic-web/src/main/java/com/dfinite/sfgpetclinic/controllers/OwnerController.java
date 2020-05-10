package com.dfinite.sfgpetclinic.controllers;

import com.dfinite.sfgpetclinic.model.Owner;
import com.dfinite.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController{

    private  final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedfields(WebDataBinder dataBinder)
    {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String findOwners(Model model)
    {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processedFindForm(Owner owner, BindingResult result,Model model)
    {
        // get parameterless Get request for /owners to return all records
        if(owner.getLastName() == null)
        {
            owner.setLastName(""); //empty string signifies brodest possible search
        }

        // find owners by lastName

        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");

        if(results.isEmpty())
        {
            // no owners found
            result.rejectValue("lastName","not found", "not found");
            return "owners/findOwners";
        }
        else if(results.size()==1)
        {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        }
        else {
            //multiple owner found
            model.addAttribute("selections",results);
            return "owners/ownersList";
        }

    }

    @GetMapping("/{ownerId}")
    public ModelAndView swowOwner(@PathVariable Long ownerId)
    {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;

    }


}
