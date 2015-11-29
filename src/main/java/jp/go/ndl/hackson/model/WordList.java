package jp.go.ndl.hackson.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jp.go.ndl.hackson.io.DBStringUtil;

import org.apache.commons.lang3.StringUtils;

public class WordList implements DBOutputModel {

	private Random seed = new Random();

	String[] dbColumns = { "id", "wcount", "wcount_read", "value", "value_read","hint" };
	String[] dbTypeColumns = { "word_id", "type", "typevalue" };

	String id;
	String value;
	String reading;
	List<String> ndcList;

	int valueCount;
	int readingCount;

	public void calc() {
		if (StringUtils.isNotEmpty(value)) {
			valueCount = value.length();
		}

		if (StringUtils.isNotEmpty(reading)) {
			readingCount = reading.length();
		}

		int idNum = Math.abs(value.hashCode() + seed.nextInt(99999));
		id = String.valueOf(idNum);

	}

	public WordList() {
		ndcList = new ArrayList<String>();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getReading() {
		return reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}

	public List<String> getNdcList() {
		return ndcList;
	}

	public void setNdcList(List<String> ndcList) {
		this.ndcList = ndcList;
	}

	public String dbValueString() {

		String[] result = new String[6];
		result[0] = DBStringUtil.convertSinglePhase(id);
		result[1] = String.valueOf(valueCount);
		result[2] = String.valueOf(readingCount);
		result[3] = DBStringUtil.convertSinglePhase(value);
		result[4] = DBStringUtil.convertSinglePhase(reading);
		result[5] = DBStringUtil.convertSinglePhase(reading);

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

		for (String type : ndcList) {
			String[] result = new String[3];
			result[0] = DBStringUtil.convertSinglePhase(id);
			result[1] = DBStringUtil.convertSinglePhase("ndc");
			result[2] = DBStringUtil.convertSinglePhase(type);

			list.add(DBStringUtil.phaseString(result));
		}

		return list;
	}
	
	public List<String> outputLine(){
		List<String> result = new ArrayList<String>();
		result.add(value);
		result.add(reading);
		result.add(reading);
		result.add(value);
		
		return result;
		
	}
	
	

}
