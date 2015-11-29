package jp.go.ndl.hackson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.go.ndl.hackson.io.TitleFileReader;
import jp.go.ndl.hackson.model.TitleWord;
import jp.go.ndl.hackson.model.text.TitleWordForText;

import org.apache.commons.io.FileUtils;

public class TitleMain {

	public static void main(String[] args) throws IOException {
		TitleFileReader r = new TitleFileReader();
		List<TitleWord> list = r.read(args[0]);
		
		List<String> textList = new ArrayList<String>();
		
		//List<String> textList =list.stream().map(word->word.outputLine()).collect(Collectors.toList());
		
		for(TitleWord word: list){
			TitleWordForText proxy = new TitleWordForText(word);
			textList.addAll(proxy.outputLine());
		}
		
		int size = textList.size()/2;

		textList.add(0, String.valueOf(size));
		
		FileUtils.writeLines(new File(args[1]), textList);
	}

}
