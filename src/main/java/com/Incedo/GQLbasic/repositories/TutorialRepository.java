package com.Incedo.GQLbasic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Incedo.GQLbasic.models.Tutorial;

@Repository
public  interface TutorialRepository extends JpaRepository<Tutorial, Integer>{

}
