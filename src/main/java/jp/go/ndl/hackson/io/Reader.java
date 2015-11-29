package jp.go.ndl.hackson.io;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Reader<T> {
	
	public List<T> read(String file) throws IOException;

}
