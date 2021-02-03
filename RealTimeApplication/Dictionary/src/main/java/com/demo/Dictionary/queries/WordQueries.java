package com.demo.Dictionary.queries;

import com.demo.Dictionary.table.constants.WordTableConstants;

public class WordQueries {

	public WordQueries() {
		// TODO Auto-generated constructor stub
	}

	public static final String INSERT_QUERY = "INSERT INTO " + WordTableConstants.TABLE_NAME + "("
			+ WordTableConstants.WORD + " , " + WordTableConstants.MEANING + " , " + WordTableConstants.POS + " , "
			+ WordTableConstants.EXAMPLE + " , " + WordTableConstants.CREATION_TM + " , "
			+ WordTableConstants.LAST_MODIFIED_TM + ") " + " VALUES (" + " :" + WordTableConstants.WORD + " , :"
			+ WordTableConstants.MEANING + " , :" + WordTableConstants.POS + " , :" + WordTableConstants.EXAMPLE
			+ " , :" + WordTableConstants.CREATION_TM + " , :" + WordTableConstants.LAST_MODIFIED_TM + " )";

	public static final String VIEW_QUERY = "SELECT * FROM " + WordTableConstants.TABLE_NAME;
	public static final String DELETE_QUERY = "DELETE FROM " + WordTableConstants.TABLE_NAME + " where "
			+ WordTableConstants.ID + " = :" + WordTableConstants.ID;

	public static final String MATCHING_QUERY = "SELECT * FROM " + WordTableConstants.TABLE_NAME + " where "
			+ WordTableConstants.WORD + " LIKE :" + WordTableConstants.WORD + " ";

	public static final String UPDATE_QUERY_LEADING = "UPDATE " + WordTableConstants.TABLE_NAME + " SET ";

	public static final String UPDATE_QUERY_TRAILING = " WHERE " + WordTableConstants.ID + " = :"
			+ WordTableConstants.ID;
}