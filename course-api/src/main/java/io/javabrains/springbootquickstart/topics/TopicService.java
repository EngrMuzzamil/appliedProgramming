package io.javabrains.springbootquickstart.topics;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
	private List<Topic> topics =  Arrays.asList(
			
			new Topic("spring","springframework","Description"),
			new Topic("spring2","springframework","Description"),
			new Topic("spring3","springframework","Description")
		);
	
	
	public List<Topic> getAllTopics() 
	{
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopics(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopics(String id, Topic topics2) {
		for(int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topics2);
				return;
			}
		}
	}
	
	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}

}
