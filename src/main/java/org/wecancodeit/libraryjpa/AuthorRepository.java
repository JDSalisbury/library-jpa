package org.wecancodeit.libraryjpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
	List<Author> findByFirstName(String firstName);
}
