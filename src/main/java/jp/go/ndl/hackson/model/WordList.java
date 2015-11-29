package jp.go.ndl.hackson.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jp.go.ndl.hackson.io.db.DBStringUtil;
import jp.go.ndl.hackson.model.db.DBOutputModel;

import org.apache.commons.lang3.StringUtils;

public class WordList implements CommonData{

	private Random seed = new Random();

	private String id;
	private String value;
	private String reading;
	private List<String> ndcList;

	private int valueCount;
	private int readingCount;

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

	public int getValueCount() {
		return valueCount;
	}

	public void setValueCount(int valueCount) {
		this.valueCount = valueCount;
	}

	public int getReadingCount() {
		return readingCount;
	}

	public void setReadingCount(int readingCount) {
		this.readingCount = readingCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String getKeyword() {
		return reading;
	}

	@Override
	public String getHint() {
		return createHint();
	}

	public String createHint() {
		
		String hintTemplate = "%sに属する%sにあたる言葉";
		String ndc = String.join(",", ndcList);
		
		return String.format(hintTemplate, ndc,value);
	}

}
