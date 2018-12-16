package com.kadiremreozcan.springbootstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kadiremreozcan.springbootstarter.pojo.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
	
	
}
