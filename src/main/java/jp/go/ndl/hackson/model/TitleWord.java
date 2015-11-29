package jp.go.ndl.hackson.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import jp.go.ndl.hackson.io.DBStringUtil;

public class TitleWord {
	
	public static final Random seed = new Random();
	
	public static final String[] dbColumns = { "id", "wcount", "wcount_read", "value", "value_read","hint" };
	public static final String[] dbTypeColumns = { "word_id", "type", "typevalue" };
	
	private String id;
	private String title;
	private String titleReading;
	private String ndc;
	private String author;
	
	private int valueCount;
	private int readingCount;
	
	public TitleWord(String id,String title,String titleReading,String ndc,String author){
		
		this.id = id;
		this.title = StringUtils.deleteWhitespace(title);
		this.titleReading = StringUtils.deleteWhitespace(titleReading);
		this.ndc = ndc;
		this.author = author;
		
		if(StringUtils.isNotEmpty(title)){
			valueCount = title.length();			
		}
		if(StringUtils.isNotEmpty(titleReading)){
			readingCount = titleReading.length();
		}
		

		
	}
	
	public TitleWord() {
	}

	public List<String> outputLine(){
		List<String> result = new ArrayList<String>();
		result.add(titleReading);
		result.add(createHint());
		
		return result;
		
	}
	
	
	public String dbValueString() {

		String[] result = new String[6];
		result[0] = DBStringUtil.convertSinglePhase(id);
		result[1] = String.valueOf(valueCount);
		result[2] = String.valueOf(readingCount);
		result[3] = DBStringUtil.convertSinglePhase(title);
		result[4] = DBStringUtil.convertSinglePhase(titleReading);
		result[5] = DBStringUtil.convertSinglePhase(createHint());

		return DBStringUtil.phaseString(result);

	}

	private String createHint() {

		String hintTemplate = "NDC %sに所属する%sによる書誌のタイトル";
		
		return String.format(hintTemplate,ndc,author);
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
			result[0] = DBStringUtil.convertSinglePhase(id);
			result[1] = DBStringUtil.convertSinglePhase("ndc");
			result[2] = DBStringUtil.convertSinglePhase(ndc);

			list.add(DBStringUtil.phaseString(result));

		return list;
	}
	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNdc() {
		return ndc;
	}

	public void setNdc(String ndc) {
		this.ndc = ndc;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
