package com.dfinite.sfgpetclinic.controllers;

import com.dfinite.sfgpetclinic.model.Owner;
import com.dfinite.sfgpetclinic.model.Pet;
import com.dfinite.sfgpetclinic.model.PetType;
import com.dfinite.sfgpetclinic.services.PetService;
import com.dfinite.sfgpetclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class VisitControllerTest {

    private static final String PETS_CREATE_OR_UPDATE_VISIT_FORM="pets/createOrUpdateVisitForm";
    private static final String REDIRECT_OWNERS_1="redirect:/owners/{ownerId}";
    private static final String YET_ANOTHER_VISIT_DESCRIPTION="yet another visit";

    @Mock
    PetService petService;

    @Mock
    VisitService visitService;

    @InjectMocks
    VisitController visitController;

    private MockMvc mockMvc;

    private final UriTemplate visitUrlTemplate = new UriTemplate("/owners/{ownerId}/pets/{petId}/visits/new");
    private final Map<String,String> uriVaraibles = new HashMap<>();
    private URI visitUri;

    @BeforeEach
    void setUp()
    {
        Long petId =1l;
        Long ownerId=1l;

        when(petService.findById(anyLong())).thenReturn(Pet.builder().id(petId).birthDate(LocalDate.of(2018,11,13))
                        .name("Cuite").visitSet(new HashSet<>())
                        .owner(Owner.builder().id(ownerId).lastName("Doe").firstName("joe").build())
                        .petType(PetType.builder().name("Dog").build()).build());

        uriVaraibles.clear();
        uriVaraibles.put("ownerId",ownerId.toString());
        uriVaraibles.put("petId",petId.toString());
        visitUri=visitUrlTemplate.expand(uriVaraibles);

        mockMvc = MockMvcBuilders
                .standaloneSetup(visitController)
                .build();
    }

    @Test
    void initNewVisitForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(visitUri))
                .andExpect(status().isOk())
                .andExpect(view().name(PETS_CREATE_OR_UPDATE_VISIT_FORM))
        ;
    }


    @Test
    void processNewVisitForm() throws Exception {
        mockMvc.perform(post(visitUri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("date","2018-11-11")
                .param("description", YET_ANOTHER_VISIT_DESCRIPTION))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name(REDIRECT_OWNERS_1))
                .andExpect(model().attributeExists("visit"))
        ;
    }
}
