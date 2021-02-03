package com.demo.Dictionary.dao;

import java.text.ParseException;
import java.util.List;

import com.demo.Dictionary.entities.Word;

public interface IWordDao {
	public Word save(Word word) throws ParseException;

	public List<Word> getAll();

	public int deleteById(int id);

	public List<Word> searchByPattern(String pattern);

	public int update(Word word);
}
