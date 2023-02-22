package com.Incedo.GQLbasic.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

import com.Incedo.GQLbasic.models.Author;
import com.Incedo.GQLbasic.models.Tutorial;
import com.Incedo.GQLbasic.repositories.AuthorRepository;
import com.Incedo.GQLbasic.repositories.TutorialRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class MutationRes implements GraphQLMutationResolver{
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	 private TutorialRepository tutorialRepository;

	  @Autowired
	  public MutationRes(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
	    this.authorRepository = authorRepository;
	    this.tutorialRepository = tutorialRepository;
	  }

	  @MutationMapping
	  public Author createAuthor(int id,String name, Integer age) {
		  System.out.println("into createAuthor");
	    Author author = new Author();
	    author.setId(id);
	    author.setName(name);
	    author.setAge(age);

	    authorRepository.save(author);

	    return author;
	  }
	  public Tutorial createTutorial(String title, String description, int authorId) {
		    Tutorial tutorial = new Tutorial();
		    tutorial.setAuthor(new Author(authorId));
		    tutorial.setTitle(title);
		    tutorial.setDescription(description);

		    tutorialRepository.save(tutorial);

		    return tutorial;
		  }

		  public boolean deleteTutorial(int id) {
		    tutorialRepository.deleteById(id);
		    return true;
		  }

		  public Tutorial updateTutorial(int id, String title, String description) throws NotFoundException {
		    Optional<Tutorial> optTutorial = tutorialRepository.findById(id);

		    if (optTutorial.isPresent()) {
		      Tutorial tutorial = optTutorial.get();

		      if (title != null)
		        tutorial.setTitle(title);
		      if (description != null)
		        tutorial.setDescription(description);

		      tutorialRepository.save(tutorial);
		      return tutorial;
		    }

		    throw new NotFoundException();
		  }

}
