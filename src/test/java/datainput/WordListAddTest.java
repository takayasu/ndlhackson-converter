package datainput;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;
import java.util.List;

import jp.go.ndl.hackson.io.Reader;
import jp.go.ndl.hackson.io.WordListReader;
import jp.go.ndl.hackson.io.db.DBOutputWordLineWriter;
import jp.go.ndl.hackson.model.WordList;

import org.junit.Test;

public class WordListAddTest {

	@Test
	public void test() throws IOException {
		
		Reader<WordList> r = new WordListReader();
		
		List<WordList> list = r.read("data/NDC9-1_utf8.txt");
		
		assertThat(list.size(),is(25577));
		
		DBOutputWordLineWriter writer = new DBOutputWordLineWriter();

		for(WordList word : list){
			System.out.println(writer.wordList(word));
		}
		
		for(WordList word : list){
			
			List<String> sqlStrings = writer.wordType(word);
			
			for(String sql: sqlStrings){
				System.out.println(sql);	
			}

		}
		
	}

}
