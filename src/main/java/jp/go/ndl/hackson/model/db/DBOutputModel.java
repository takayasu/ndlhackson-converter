package jp.go.ndl.hackson.model.db;

import java.util.List;

public interface DBOutputModel {
	public String dbValueString();
	public String dbColumnString();
	
	public List<String> dbValueTypeString();
	public String dbColumnStringType();
}
