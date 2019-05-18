package io.example.course.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	private PostRepository postRepository;
	
	public List<Post> getAllPost() {
		List<Post> post = new ArrayList<>();
		postRepository.findAll().forEach(post::add);
		return post;
	}
	
	public Post getPost(String id) {
		
		return postRepository.findOne(id);
	}

	public void addPost(Post post2) {
		postRepository.save(post2);
	}

	public void updatePost(String id, Post post2) {
		postRepository.save(post2);
	}

	public void deletePost(String id) {
		postRepository.delete(id);
	}
}
