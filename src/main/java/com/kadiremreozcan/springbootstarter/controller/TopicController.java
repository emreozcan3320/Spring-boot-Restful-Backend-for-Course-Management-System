package com.kadiremreozcan.springbootstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadiremreozcan.springbootstarter.pojo.Topic;
import com.kadiremreozcan.springbootstarter.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {		
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getSingleTopic(@PathVariable String id) {		
		return topicService.getSingleTopic(id);
	}
	
	
}
