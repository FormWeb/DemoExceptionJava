package com.techni.demoexception.controllers;

import com.techni.demoexception.exception.AuthorNotFoundException;
import com.techni.demoexception.models.dtos.AuthorDTO;
import com.techni.demoexception.models.forms.AuthorForm;
import com.techni.demoexception.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping
    public Long insert(@Valid @RequestBody AuthorForm form) {
        return service.add(form);
    }

    @GetMapping("/{id}")
    public AuthorDTO getById(@PathVariable("id") long id) {
        try {
            return service.getById(id);
        }
        catch (AuthorNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong id", ex);
        }
    }
}
