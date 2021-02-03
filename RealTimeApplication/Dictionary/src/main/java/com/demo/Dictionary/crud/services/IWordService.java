package com.demo.Dictionary.crud.services;

import java.text.ParseException;
import java.util.List;

import com.demo.Dictionary.entities.Word;

public interface IWordService {
	public Word save(Word word) throws ParseException;

	public List<Word> getAll();

	public boolean delete(int id);

	public List<Word> getMatching(String pattern);

	public boolean update(Word word);

}
