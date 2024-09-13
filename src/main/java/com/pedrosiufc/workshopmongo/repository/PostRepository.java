package com.pedrosiufc.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pedrosiufc.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	//pega o primeiro parametro com ?0 e i para ignore case buscando no title
	@Query("\"{ 'title': { $regex: ?0, $options: 'i' } }\"")
	List<Post> searchTitle(String text);

	List<Post> findByTitleContainingIgnoreCase(String text);
}
