package jp.go.ndl.hackson.io;

import java.util.ArrayList;
import java.util.List;

import jp.go.ndl.hackson.model.WordList;

public class DBOutputWordLineWriter implements Writer<WordList> {

	private static final String WORD_TABLE = "insert into words %s values %s;";
	private static final String WORD_TYPE_TABLE = "insert into words_type %s values %s;";
	
	
	public String wordList(WordList word) {
		return String.format(WORD_TABLE, word.dbColumnString(),word.dbValueString());		
	}

	public List<String> wordType(WordList word) {
		
		List<String> list = new ArrayList<String>();
		
		for(String value : word.dbValueTypeString()){
			String single = String.format(WORD_TYPE_TABLE, word.dbColumnStringType(),value);
			list.add(single);
		}
		
		return list;
	}

}
