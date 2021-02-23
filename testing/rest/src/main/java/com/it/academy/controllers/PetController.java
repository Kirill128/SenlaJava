package com.it.academy.controllers;

import com.it.academy.api.dto.PetEntityDto;
import com.it.academy.api.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private IPetService petService;

    @GetMapping(value="/{id}")
    public PetEntityDto findPet(@PathVariable int id){
        return this.petService.getPet(id);
    }
}

