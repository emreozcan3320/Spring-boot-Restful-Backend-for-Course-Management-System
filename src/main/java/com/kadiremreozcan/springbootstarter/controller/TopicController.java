package com.kadiremreozcan.springbootstarter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadiremreozcan.springbootstarter.pojo.Topic;

@RestController
public class TopicController {
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		List<Topic> myList = new ArrayList<>();
		myList.add(new Topic("1", "Java", "java JVM mantigi"));
		myList.add(new Topic("2", "Java", "Garage Collection Algortihm"));
		myList.add(new Topic("3", "Java", "String and String pool and intern() method"));
		
		return myList;
	}
}
