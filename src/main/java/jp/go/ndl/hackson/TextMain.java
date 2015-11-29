package jp.go.ndl.hackson;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import jp.go.ndl.hackson.io.Reader;
import jp.go.ndl.hackson.io.WordListReader;
import jp.go.ndl.hackson.io.text.TextDataWriter;
import jp.go.ndl.hackson.model.CommonData;
import jp.go.ndl.hackson.model.WordList;

public class TextMain {

	public static void main(String[] args) throws IOException {

		Reader<WordList> r = new WordListReader();
		List<WordList> list = r.read(args[0]);
		
		TextDataWriter.write(args[1], list.stream().map(data->(CommonData)data).collect(Collectors.toList()));

		
	}

}
