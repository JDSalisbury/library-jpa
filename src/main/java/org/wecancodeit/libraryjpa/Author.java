package org.wecancodeit.libraryjpa;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;




@Entity
public class Author {

	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	
	
	@ManyToMany
	private Collection<Book> books;
	
	@SuppressWarnings("unused")//because ide stating unused
	private Author() {} //needed for JPA to construct object
	
	
	public Author(String firstName, String lastName, Book...books) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = new HashSet<>(asList(books));
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public Collection<Book> getBooks() {
		// TODO Auto-generated method stub
		return books;
	}


	
	
}
