package com.techni.demoexception.models.dtos;

import com.techni.demoexception.models.entities.Author;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AuthorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public static AuthorDTO toDTO(Author entity) {

        AuthorDTO dto = new AuthorDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setBirthDate(entity.getBirthDate());

        return dto;
    }
}
