package jp.go.ndl.hackson.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import jp.go.ndl.hackson.model.WordList;

public class WordListReader implements Reader<WordList> {

	public List<WordList> read(String file) throws IOException {

		List<WordList> list = new ArrayList<WordList>();
		
		if(StringUtils.isEmpty(file)){
			System.err.println("FilePath is not string.");
			return list;
		}
		
		File f = new File(file);
		
		LineIterator it = FileUtils.lineIterator(f, "UTF-8");
		
		try{
			while(it.hasNext()){
				list.add(createOne(it.nextLine()));
			}
			
		}finally{
			it.close();
		}
		

		return list;
	}
	
	private WordList createOne(String line){
				
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
