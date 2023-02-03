package com.techni.demoexception.services;

import com.techni.demoexception.models.dtos.AuthorDTO;
import com.techni.demoexception.models.forms.AuthorForm;

public interface AuthorService {
    Long add(AuthorForm form);
    AuthorDTO getById(Long id);
}
