package com.kadiremreozcan.springbootstarter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kadiremreozcan.springbootstarter.pojo.Topic;

@Service
public class TopicService {

	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("1", "Java", "java JVM mantigi"),
			new Topic("2", "Java", "Garage Collection Algortihm"),
			new Topic("3", "Java", "String and String pool and intern() method")
			));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getSingleTopic(String id) {
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
		
		 return topics.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(new Topic());
		
	}

	public void addTopic(Topic topic) {

		topics.add(topic);
		
	}

}
