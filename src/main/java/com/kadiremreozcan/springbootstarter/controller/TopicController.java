package com.kadiremreozcan.springbootstarter.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kadiremreozcan.springbootstarter.pojo.Topic;
import com.kadiremreozcan.springbootstarter.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable Long id) {		
		return topicService.getSingleTopic(id);
	}
	
	@PostMapping("/topics")
	public ResponseEntity<Object> addTopic(@RequestBody Topic topic) {
		Topic Addedtopic = topicService.addTopic(topic);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(Addedtopic.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/topics/{id}")
	public void UpdateTopic(@RequestBody Topic topic, @PathVariable long id) {
		
	}
	
	@DeleteMapping("/topics/{id}")
	public void DeleteTopic( @PathVariable Long id) {
		topicService.deleteTopic(id);
	}
}
