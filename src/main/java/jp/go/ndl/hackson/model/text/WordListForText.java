package jp.go.ndl.hackson.model.text;

import java.util.ArrayList;
import java.util.List;

import jp.go.ndl.hackson.model.WordList;

public class WordListForText {
	
	private WordList target;
	
	public WordListForText(WordList word){
		target = word;
	}

	public List<String> outputLine() {
		List<String> result = new ArrayList<String>();
		result.add(target.getValue());
		result.add(target.getReading());
		result.add(target.getReading());
		result.add(target.getValue());
		
		return result;

	}
}
