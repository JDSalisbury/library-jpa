package org.wecancodeit.libraryjpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


import org.junit.Test;

public class GenreTest {

	@Test
	public void shouldgetGenre() {
		Genre underTest = new Genre("Fiction");
		
		String check = underTest.getGenre();
		assertThat(check, is("Fiction"));
	}
	
	
}
