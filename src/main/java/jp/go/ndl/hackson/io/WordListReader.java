package jp.go.ndl.hackson.io;

import java.util.Arrays;
import java.util.List;

import jp.go.ndl.hackson.model.WordList;

public class WordListReader extends AbstractReader<WordList> {
	
	public WordList createOne(String line){
				
		String[] items = line.split("\t");
		
		WordList word = new WordList();
		word.setValue(items[0]);
		word.setReading(items[1]);
		
		if(items.length == 3){
			word.setNdcList(createNDCList(items[2]));			
		}

		word.calc();
		
		return word;
		
	}
	
	private List<String> createNDCList(String value){
		
		String[] wordList = value.split(",");		
		return Arrays.asList(wordList);
		
	}
	
	
	

}
