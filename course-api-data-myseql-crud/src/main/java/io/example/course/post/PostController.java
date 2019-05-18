package io.example.course.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("/posttopic")
	public List<Post> getAllPost() {
		
		return postService.getAllPost();
	}
	
	@RequestMapping("/posttopic/{id}")
	public Post getPost(@PathVariable String id) {
		
		return postService.getPost(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/posttopic")
	public void addPost(@RequestBody Post post2) {
		postService.addPost(post2);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/posttopic/{id}")
	public void updatePost(@RequestBody Post post, @PathVariable String id) {
		postService.updatePost(id, post);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/posttopic/{id}")
	public void deletePost(@PathVariable String id) {
		
		postService.deletePost(id);
	}
}
