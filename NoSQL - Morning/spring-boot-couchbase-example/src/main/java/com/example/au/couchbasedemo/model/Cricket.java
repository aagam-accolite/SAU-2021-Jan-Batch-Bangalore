package com.example.au.couchbasedemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class Cricket {
	@Id
    String id;
	
	@NotNull
	@Field
	String name;
	
	@NotNull
	@Field
	int avg;
	
	@NotNull
	@Field
	int runs;
	
	@NotNull
	@Field
	int wicket;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWicket() {
		return wicket;
	}

	public void setWicket(int wicket) {
		this.wicket = wicket;
	}
	public Cricket(String id,String name,int avg,int runs,int wicket)
	{
		super();
		this.id = id;
		this.name = name;
		this.avg = avg;
		this.runs = runs;
		this.wicket = wicket;
	}
	
}
