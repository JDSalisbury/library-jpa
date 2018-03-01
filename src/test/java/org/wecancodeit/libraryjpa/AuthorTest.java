package org.wecancodeit.libraryjpa;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;



import org.junit.Test;

public class AuthorTest {
	
	
	@Test
	public void shouldFindFirstName() {
		Author underTest = new Author("Steve","Erickson");
		
				
		underTest.getFirstName(); 
		String check = underTest.getFirstName();
		
		assertThat(check, is("Steve"));
				
	}
	
	
	@Test
	public void shouldFindLastName() {
		Author underTest = new Author("Steve","Erickson");
		
				
		underTest.getLastName(); 
		String check = underTest.getLastName();
		
		assertThat(check, is("Erickson"));

	}
}
