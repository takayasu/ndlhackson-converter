package jp.go.ndl.hackson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import jp.go.ndl.hackson.io.Reader;
import jp.go.ndl.hackson.io.WordListReader;
import jp.go.ndl.hackson.model.WordList;

public class TextMain {

	public static void main(String[] args) throws IOException {

		Reader<WordList> r = new WordListReader();
		List<WordList> list = r.read("data/NDC9-1_utf8.txt");
		
		List<String> textList = new ArrayList<String>();
		
		for(WordList word: list){
			textList.addAll(word.outputLine());
		}
		
		assert(textList.size() % 2 == 0);
		int size = textList.size() /2 ;

		textList.add(0, String.valueOf(size));
		
		FileUtils.writeLines(new File("data/output.txt"), textList);
		
	}

}
