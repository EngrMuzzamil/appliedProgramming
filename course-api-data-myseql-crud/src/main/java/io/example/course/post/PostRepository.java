package io.example.course.post;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, String> {

	Post findOne(String id);

	void delete(String id);

}
