package com.kadiremreozcan.springbootstarter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kadiremreozcan.springbootstarter.exception.TopicNotFoundException;
import com.kadiremreozcan.springbootstarter.pojo.Topic;
import com.kadiremreozcan.springbootstarter.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		return topicRepository.findAll();
	}

	public Topic getSingleTopic(Long id) {
		/* 
		 * Looping with an Iterator
		 * */
		/*
		 for (Topic topic : topics) {
		        if (topic.getId().equals(id)) {
		            return topic;
		        }
		    }
		 
		return new Topic();
		*/
		
		/*
		 * Java 8 Stream API
		 * */
		
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(new Topic());
		Optional<Topic> topic = topicRepository.findById(id);
		if (!topic.isPresent())
			throw new TopicNotFoundException("id-" + id);
		return topic.get();
		
	}

	public Topic addTopic(Topic topic) {

		return topicRepository.save(topic)	;
		
	}

	public ResponseEntity<Object> updateTopic(Long id, Topic topic) {
		
//		 for (int i = 0; i<topics.size();i++) {
//			 Topic t = topics.get(i);
//		        if (t.getId().equals(id)) {
//		            topics.set(i, topic);
//		        }
//		    }
		Optional<Topic> topicOptional = topicRepository.findById(id);
		if (!topicOptional.isPresent())
			return ResponseEntity.notFound().build();

		topic.setId(id);
		
		topicRepository.save(topic);

		return ResponseEntity.noContent().build();
		
	}
	
	public void deleteTopic(Long id) {

		topicRepository.deleteById(id);	
		
	}

	

}