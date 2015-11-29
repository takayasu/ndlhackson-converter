package jp.go.ndl.hackson.model.db;

import java.util.ArrayList;
import java.util.List;

import jp.go.ndl.hackson.io.db.DBStringUtil;
import jp.go.ndl.hackson.model.WordList;

public class WordListForDB implements DBOutputModel{
	
	private static final String[] dbColumns = { "id", "wcount", "wcount_read", "value", "value_read","hint" };
	private static final String[] dbTypeColumns = { "word_id", "type", "typevalue" };

	private WordList target;
	
	public WordListForDB(WordList word){
		target = word;
	}	

	public String dbValueString() {

		String[] result = new String[6];
		result[0] = DBStringUtil.convertSinglePhase(target.getId());
		result[1] = String.valueOf(target.getValueCount());
		result[2] = String.valueOf(target.getReadingCount());
		result[3] = DBStringUtil.convertSinglePhase(target.getValue());
		result[4] = DBStringUtil.convertSinglePhase(target.getReading());
		result[5] = DBStringUtil.convertSinglePhase(target.getReading());

		return DBStringUtil.phaseString(result);

	}

	public List<String> dbValueTypeString() {

		List<String> list = new ArrayList<String>();

		for (String type : target.getNdcList()) {
			String[] result = new String[3];
			result[0] = DBStringUtil.convertSinglePhase(target.getId());
			result[1] = DBStringUtil.convertSinglePhase("ndc");
			result[2] = DBStringUtil.convertSinglePhase(type);

			list.add(DBStringUtil.phaseString(result));
		}

		return list;
	}
	
	public String dbColumnString() {
		return DBStringUtil.phaseString(dbColumns);
	}



	public String dbColumnStringType() {
		return DBStringUtil.phaseString(dbTypeColumns);
	}
	

}
