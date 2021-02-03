package com.demo.Dictionary.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.demo.Dictionary.dao.IWordDao;
import com.demo.Dictionary.entities.Word;
import com.demo.Dictionary.queries.WordQueries;
import com.demo.Dictionary.table.constants.WordTableConstants;
import com.demo.Dictionary.utilities.CustomComparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class WordDaoImpl implements IWordDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private static Logger logger = LoggerFactory.getLogger(WordDaoImpl.class);

	@Override
	public Word save(Word word) throws ParseException {
		final KeyHolder holder = new GeneratedKeyHolder();
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue(WordTableConstants.WORD, word.getWord());
		srcMap.addValue(WordTableConstants.MEANING, word.getMeaning());
		srcMap.addValue(WordTableConstants.POS, word.getPartOfSpeech());
		srcMap.addValue(WordTableConstants.EXAMPLE, word.getExample());
		srcMap.addValue(WordTableConstants.CREATION_TM,
				word.getCreationTm() == null ? new Date() : word.getCreationTm());
		srcMap.addValue(WordTableConstants.LAST_MODIFIED_TM, new Date());
		logger.info(new Date().toString());

		namedParameterJdbcTemplate.update(WordQueries.INSERT_QUERY, srcMap, holder,
				new String[] { WordTableConstants.ID });
		word.setId(holder.getKey().intValue());
		return word;
	}

	@Override
	public int update(Word word) {
		// TODO Auto-generated method stub
		String UPDATE_QUERY = WordQueries.UPDATE_QUERY_LEADING;
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		if (word.getWord() != null) {
			UPDATE_QUERY += " " + WordTableConstants.WORD + " = :" + WordTableConstants.WORD + " , ";
			srcMap.addValue(WordTableConstants.WORD, word.getWord());
		}
		if (word.getMeaning() != null) {
			UPDATE_QUERY += " " + WordTableConstants.MEANING + " = :" + WordTableConstants.MEANING + " , ";
			srcMap.addValue(WordTableConstants.MEANING, word.getMeaning());
		}
		if (word.getPartOfSpeech() != null) {
			UPDATE_QUERY += " " + WordTableConstants.POS + " = :" + WordTableConstants.POS + " , ";
			srcMap.addValue(WordTableConstants.POS, word.getPartOfSpeech());
		}
		if (word.getExample() != null) {
			UPDATE_QUERY += " " + WordTableConstants.EXAMPLE + " = :" + WordTableConstants.EXAMPLE + " , ";
			srcMap.addValue(WordTableConstants.EXAMPLE, word.getExample());
		}

		UPDATE_QUERY += " " + WordTableConstants.LAST_MODIFIED_TM + " = :" + WordTableConstants.LAST_MODIFIED_TM
				+ " , ";
		srcMap.addValue(WordTableConstants.LAST_MODIFIED_TM, new Date());

		UPDATE_QUERY = UPDATE_QUERY.substring(0, UPDATE_QUERY.length() - 2);
		UPDATE_QUERY += " " + WordQueries.UPDATE_QUERY_TRAILING;

		logger.info(UPDATE_QUERY);
		srcMap.addValue(WordTableConstants.ID, word.getId());

		return namedParameterJdbcTemplate.update(UPDATE_QUERY, srcMap);

	}

	@Override
	public List<Word> getAll() {
		logger.info(WordQueries.VIEW_QUERY);

		List<Word> wordList = namedParameterJdbcTemplate.query(WordQueries.VIEW_QUERY, (resultSet, rowNum) -> {
			Word word = new Word();
			word.setId(resultSet.getInt(WordTableConstants.ID));
			word.setCreationTm(resultSet.getDate(WordTableConstants.CREATION_TM));
			word.setExample(resultSet.getString(WordTableConstants.EXAMPLE));
			word.setLastModifiedTm(resultSet.getDate(WordTableConstants.LAST_MODIFIED_TM));
			word.setMeaning(resultSet.getString(WordTableConstants.MEANING));
			word.setPartOfSpeech(resultSet.getString(WordTableConstants.POS));
			word.setWord(resultSet.getString(WordTableConstants.WORD));
			return word;
		});
		Collections.sort(wordList);
		return wordList;
	}

	@Override
	public List<Word> searchByPattern(String pattern) {
		MapSqlParameterSource srcMap = new MapSqlParameterSource();
		srcMap.addValue(WordTableConstants.WORD, "%" + pattern + "%");
		logger.info(WordQueries.MATCHING_QUERY);
		return namedParameterJdbcTemplate.query(WordQueries.MATCHING_QUERY, srcMap, (resultSet, rowNum) -> {
			Word word = new Word();
			word.setId(resultSet.getInt(WordTableConstants.ID));
			word.setCreationTm(resultSet.getDate(WordTableConstants.CREATION_TM));
			word.setExample(resultSet.getString(WordTableConstants.EXAMPLE));
			word.setLastModifiedTm(resultSet.getDate(WordTableConstants.LAST_MODIFIED_TM));
			word.setMeaning(resultSet.getString(WordTableConstants.MEANING));
			word.setPartOfSpeech(resultSet.getString(WordTableConstants.POS));
			word.setWord(resultSet.getString(WordTableConstants.WORD));
			return word;
		});
	}
	
	@Override
	public int deleteById(int id) {
		logger.info(WordQueries.DELETE_QUERY);
		MapSqlParameterSource srcMap = new MapSqlParameterSource();

		srcMap.addValue(WordTableConstants.ID, id);
		return namedParameterJdbcTemplate.update(WordQueries.DELETE_QUERY, srcMap);
	}

}
