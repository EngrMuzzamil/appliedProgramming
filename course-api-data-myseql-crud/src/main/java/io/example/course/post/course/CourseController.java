package io.example.course.post.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService postService;
	
	@RequestMapping("/posttopic")
	public List<Course> getAllPost() {
		
		return postService.getAllPost();
	}
	
	@RequestMapping("/posttopic/{id}")
	public Course getPost(@PathVariable String id) {
		
		return postService.getPost(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/posttopic")
	public void addPost(@RequestBody Course post2) {
		postService.addPost(post2);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/posttopic/{id}")
	public void updatePost(@RequestBody Course post, @PathVariable String id) {
		postService.updatePost(id, post);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/posttopic/{id}")
	public void deletePost(@PathVariable String id) {
		
		postService.deletePost(id);
	}
}
