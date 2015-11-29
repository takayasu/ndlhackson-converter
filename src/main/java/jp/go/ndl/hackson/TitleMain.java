package jp.go.ndl.hackson;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import jp.go.ndl.hackson.io.Reader;
import jp.go.ndl.hackson.io.TitleFileReader;
import jp.go.ndl.hackson.io.text.TextDataWriter;
import jp.go.ndl.hackson.model.CommonData;
import jp.go.ndl.hackson.model.TitleWord;

public class TitleMain {

	public static void main(String[] args) throws IOException {

		Reader<TitleWord> r = new TitleFileReader();
		List<TitleWord> list = r.read(args[0]);
		
		TextDataWriter.write(args[1], list.stream().map(data->(CommonData)data).collect(Collectors.toList()));

	}

}
