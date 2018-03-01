package org.wecancodeit.libraryjpa;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Book {
	@ManyToOne
	private Genre genre;
	@Id
	@GeneratedValue
	private long id;
	private String title;



	public Book() {}
	
	@ManyToMany(mappedBy = "books")
	private Collection<Author> authors;
	
	public Book(String title) {
		this.title = title;
		// TODO Auto-generated constructor stub
	}
	
	public Genre getGenre() {
		// TODO Auto-generated method stub
		return genre;
	}
	
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (int) (id ^ (id >>> 32));
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Book other = (Book) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}

	
	
	
	
}
