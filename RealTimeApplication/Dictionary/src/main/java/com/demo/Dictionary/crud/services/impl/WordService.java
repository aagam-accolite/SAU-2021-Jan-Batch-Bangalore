package com.demo.Dictionary.crud.services.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Dictionary.crud.services.IWordService;
import com.demo.Dictionary.dao.IWordDao;
import com.demo.Dictionary.entities.Word;

@Service
public class WordService implements IWordService {

	@Autowired
	IWordDao iWordDao;

	@Override
	public Word save(Word word) throws ParseException {
		return iWordDao.save(word);
	}

	@Override
	public List<Word> getAll() {
		return iWordDao.getAll();
	}

	@Override
	public boolean delete(int id) {
		int num = iWordDao.deleteById(id);
		if (num == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<Word> getMatching(String pattern) {
		return iWordDao.searchByPattern(pattern);
	}

	@Override
	public boolean update(Word word)
	{
		int num = iWordDao.update(word);
		if (num == 1) {
			return true;
		}
		return false;
	}

}