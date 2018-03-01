package org.wecancodeit.libraryjpa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class LibraryMappingTest {
	@Resource
	private TestEntityManager entityManager;  
	

	@Resource
	private AuthorRepository authorRepo;
	
	@Resource
	private GenreRepository genreRepo;

	@Resource
	private BookRepository bookRepo;
	
	@Test
	public void shouldSaveAndLoadAuthors() {
		Author author = new Author("Steve","Erickson"); 
		author = authorRepo.save(author); 
		long authorId = author.getId();
		
		entityManager.flush(); 
		entityManager.clear();
		
		author = authorRepo.findOne(authorId);
		
		assertThat(author.getFirstName(), is("Steve"));
		
	}
	
	@Test
	public void shouldSaveAndLoadGenre() {
		Genre genre = new Genre("Fiction"); 
		genre = genreRepo.save(genre); 
		long genreId = genre.getId();
		
		entityManager.flush(); 
		entityManager.clear();
		
		genre = genreRepo.findOne(genreId);
		
		assertThat(genre.getGenre(), is("Fiction"));
		
	}
	
	
	@Test
	public void shouldSaveAndLoadBook() {
		Book book = new Book("The Road"); 
		book = bookRepo.save(book); 
		long bookId = book.getId();
		
		entityManager.flush(); 
		entityManager.clear();
		
		book = bookRepo.findOne(bookId);
		
		assertThat(book.getTitle(), is("The Road"));
	}
	
	
	@Test
	public void shouldSaveGenreToBookRelationShip() {
		Book book = new Book("The Road");
		book = bookRepo.save(book);//once saved id created
		long bookId = book.getId(); 
		
		Genre genre = new Genre("Fiction"); 
		genreRepo.save(genre);//id?
		book.setGenre(genre);
		
		
		entityManager.flush(); 
		entityManager.clear();
		
		book = bookRepo.findOne(bookId);

		assertThat(book.getGenre(), is(genre));
	}
	
	@Test
	public void  shouldSaveAuthorToBookRelationShip() {
		Book hamlet = bookRepo.save(new Book("Hamlet"));
		Book macbeth = bookRepo.save(new Book("MacBeth"));
		
		Author bill = new Author("William", "Shakespeare", hamlet, macbeth);
		bill = authorRepo.save(bill);
		long authorId = bill.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		bill = authorRepo.findOne(authorId);
		assertThat(bill.getBooks(), containsInAnyOrder(hamlet, macbeth));
	}
	
	
	
	
	
}
