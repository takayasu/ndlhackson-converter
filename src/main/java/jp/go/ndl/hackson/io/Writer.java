package jp.go.ndl.hackson.io;

import java.util.List;

public interface Writer<T> {
	
	public String wordList(T word);
	
	public List<String> wordType(T word);
	
	

}
