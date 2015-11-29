package jp.go.ndl.hackson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import jp.go.ndl.hackson.io.DBOutputWordLineWriter;
import jp.go.ndl.hackson.io.Reader;
import jp.go.ndl.hackson.io.WordListReader;
import jp.go.ndl.hackson.model.WordList;

public class Main {

	public static void main(String[] args) throws IOException {

		Reader<WordList> r = new WordListReader();

		List<WordList> list = r.read("data/NDC9-1_utf8.txt");

		DBOutputWordLineWriter writer = new DBOutputWordLineWriter();

		List<String> sql1 = new ArrayList<String>();
		List<String> sql2 = new ArrayList<String>();

		for (WordList word : list) {
			sql1.add(writer.wordList(word));
			sql2.addAll(writer.wordType(word));
		}

		FileUtils.writeLines(new File("data/word.sql"), "utf-8", sql1);
		FileUtils.writeLines(new File("data/wordtype.sql"), "utf-8", sql2);

	}

}
