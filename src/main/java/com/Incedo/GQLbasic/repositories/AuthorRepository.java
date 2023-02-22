package com.Incedo.GQLbasic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Incedo.GQLbasic.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
