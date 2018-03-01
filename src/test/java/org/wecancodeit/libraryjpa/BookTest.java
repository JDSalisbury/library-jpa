package org.wecancodeit.libraryjpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BookTest {
	@Test
	public void shouldgetBook() {
		Book underTest = new Book("Cat in the Hat");
		
		String check = underTest.getTitle();
		assertThat(check, is("Cat in the Hat"));
	}
	
}
