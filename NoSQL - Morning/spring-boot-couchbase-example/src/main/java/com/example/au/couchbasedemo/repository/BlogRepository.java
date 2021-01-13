package com.example.au.couchbasedemo.repository;

import java.util.*;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Blogs;

public interface BlogRepository extends CrudRepository<Blogs, String> {
	
	Blogs findByAuthor(String author);

	List deleteBytopicAndAuthor(String title, String author);

	Blogs[] findByTag1(String tag1);
	Blogs[] findByTag2(String tag2);
	Blogs[] findByTag3(String tag3);
	//Blogs findByTags(String tags);
}