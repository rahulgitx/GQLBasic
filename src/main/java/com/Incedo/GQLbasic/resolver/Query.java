package com.Incedo.GQLbasic.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import com.Incedo.GQLbasic.models.Author;
import com.Incedo.GQLbasic.models.Tutorial;
import com.Incedo.GQLbasic.repositories.AuthorRepository;
import com.Incedo.GQLbasic.repositories.TutorialRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver{
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	  private TutorialRepository tutorialRepository;

	  @Autowired
	  public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
		  System.out.println("Author COnstructor");
	    this.authorRepository = authorRepository;
	    this.tutorialRepository = tutorialRepository;
	  }
	  
	  @QueryMapping
	  public Iterable<Author> findAllAuthors() {
		  System.out.println("In All Authors");
	    return authorRepository.findAll();
	  }

	  public Iterable<Tutorial> findAllTutorials() {
	    return tutorialRepository.findAll();
	  }

	  public long countAuthors() {
	    return authorRepository.count();
	  }

	  public long countTutorials() {
	    return tutorialRepository.count();
	  }


}
