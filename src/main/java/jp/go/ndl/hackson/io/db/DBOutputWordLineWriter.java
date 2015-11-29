package jp.go.ndl.hackson.io.db;

import java.util.ArrayList;
import java.util.List;

import jp.go.ndl.hackson.model.WordList;
import jp.go.ndl.hackson.model.db.WordListForDB;

public class DBOutputWordLineWriter implements Writer<WordList> {

	private static final String WORD_TABLE = "insert into words %s values %s;";
	private static final String WORD_TYPE_TABLE = "insert into words_type %s values %s;";
	
	
	public String wordList(WordList word) {
		
		WordListForDB proxy = new WordListForDB(word);
		
		return String.format(WORD_TABLE, proxy.dbColumnString(),proxy.dbValueString());		
	}

	public List<String> wordType(WordList word) {
		
		WordListForDB proxy = new WordListForDB(word);
		
		List<String> list = new ArrayList<String>();
		
		for(String value : proxy.dbValueTypeString()){
			String single = String.format(WORD_TYPE_TABLE, proxy.dbColumnStringType(),value);
			list.add(single);
		}
		
		return list;
	}

}
