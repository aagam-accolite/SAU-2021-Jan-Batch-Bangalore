package com.demo.Dictionary.entities;

import java.util.Comparator;
import java.util.Date;

public class Word implements Comparable<Word> {
	private Integer id;
	private String word;
	private String meaning;
	private String partOfSpeech;
	private String example;
	private Date creationTm;
	private Date lastModifiedTm;

//
	@Override
	public int compareTo(Word word1) {
		// TODO Auto-generated method stub
		return this.creationTm.compareTo(word1.getCreationTm());
	}
//	@Override
//	public int compare(Word word1, Word word2) {
//		// TODO Auto-generated method stub
//		return word1.getCreationTm().compareTo(word2.getCreationTm());
//	}

//	public static Comparator<Word> COMPARE_BY_CREATION_TIME = new Comparator<T>() {
//		public int compare(Word word1, Word word2) {
//			return word1.creationTm.compareTo(word2.creationTm);
//		}
//	};

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getPartOfSpeech() {
		return partOfSpeech;
	}

	public void setPartOfSpeech(String partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public Date getCreationTm() {
		return creationTm;
	}

	public void setCreationTm(Date creationTm) {
		this.creationTm = creationTm;
	}

	public Date getLastModifiedTm() {
		return lastModifiedTm;
	}

	public void setLastModifiedTm(Date lastModifiedTm) {
		this.lastModifiedTm = lastModifiedTm;
	}

}
