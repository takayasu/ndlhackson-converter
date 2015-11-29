package jp.go.ndl.hackson.model.db;

import java.util.ArrayList;
import java.util.List;

import jp.go.ndl.hackson.io.db.DBStringUtil;
import jp.go.ndl.hackson.model.TitleWord;

public class TitleWordForDB implements DBOutputModel {

	private static final String[] dbColumns = { "id", "wcount", "wcount_read", "value", "value_read","hint" };
	private static final String[] dbTypeColumns = { "word_id", "type", "typevalue" };

	private TitleWord target;
	
	
	public TitleWordForDB(TitleWord target) {
		super();
		this.target = target;
	}

	public String dbValueString() {

		String[] result = new String[6];
		result[0] = DBStringUtil.convertSinglePhase(target.getId());
		result[1] = String.valueOf(target.getValueCount());
		result[2] = String.valueOf(target.getReadingCount());
		result[3] = DBStringUtil.convertSinglePhase(target.getTitle());
		result[4] = DBStringUtil.convertSinglePhase(target.getTitleReading());
		result[5] = DBStringUtil.convertSinglePhase(target.createHint());

		return DBStringUtil.phaseString(result);

	}

	public String dbColumnString() {
		return DBStringUtil.phaseString(dbColumns);
	}



	public String dbColumnStringType() {
		return DBStringUtil.phaseString(dbTypeColumns);
	}

	public List<String> dbValueTypeString() {

		List<String> list = new ArrayList<String>();

			String[] result = new String[3];
			result[0] = DBStringUtil.convertSinglePhase(target.getId());
			result[1] = DBStringUtil.convertSinglePhase("ndc");
			result[2] = DBStringUtil.convertSinglePhase(target.getNdc());

			list.add(DBStringUtil.phaseString(result));

		return list;
	}
	

}
