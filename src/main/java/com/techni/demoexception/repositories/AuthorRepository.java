package com.techni.demoexception.repositories;

import com.techni.demoexception.models.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
