package org.wecancodeit.libraryjpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
	List<Genre> findByType(String type); 
}
