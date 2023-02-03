package com.techni.demoexception.services.impl;

import com.techni.demoexception.exception.AuthorNotFoundException;
import com.techni.demoexception.exception.WrongBirthDateException;
import com.techni.demoexception.models.dtos.AuthorDTO;
import com.techni.demoexception.models.entities.Author;
import com.techni.demoexception.models.forms.AuthorForm;
import com.techni.demoexception.repositories.AuthorRepository;
import com.techni.demoexception.services.AuthorService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long add(AuthorForm form) {
        if (form.getBirthDate().isAfter(LocalDate.now())) {
            throw new WrongBirthDateException(form.getBirthDate());
        }
        Author entity = repository.save(form.toEntity());
        return entity.getId();
    }

    @Override
    public AuthorDTO getById(Long id) {
        Author entity = repository.findById(id).orElseThrow(
                () -> new AuthorNotFoundException(id)
        );

        return AuthorDTO.toDTO(entity);
    }
}
