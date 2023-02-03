package com.techni.demoexception.models.forms;

import com.techni.demoexception.models.entities.Author;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AuthorForm {
    @NotBlank(message = "First name should not be empty")
    private String firstName;
    @NotBlank(message = "Last name should not be empty")
    private String lastName;
    private LocalDate birthDate;

    public Author toEntity() {
        Author entity = new Author();

        entity.setFirstName(this.firstName);
        entity.setLastName(this.lastName);
        entity.setBirthDate(this.birthDate);

        return entity;
    }
}
