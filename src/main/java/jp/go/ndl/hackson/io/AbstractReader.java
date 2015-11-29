package jp.go.ndl.hackson.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;

public abstract class AbstractReader<T> implements Reader<T> {
	
	public List<T> read(String file) throws IOException {

		List<T> list = new ArrayList<T>();
		
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
	
	public abstract T createOne(String line);
	
	

}
