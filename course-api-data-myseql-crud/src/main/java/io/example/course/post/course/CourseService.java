package io.example.course.post.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	private CourseRepository postRepository;
	
	public List<Course> getAllPost() {
		List<Course> post = new ArrayList<>();
		postRepository.findAll().forEach(post::add);
		return post;
	}
	
	public Course getPost(String id) {
		
		return postRepository.findOne(id);
	}

	public void addPost(Course post2) {
		postRepository.save(post2);
	}

	public void updatePost(String id, Course post2) {
		postRepository.save(post2);
	}

	public void deletePost(String id) {
		postRepository.delete(id);
	}
}
