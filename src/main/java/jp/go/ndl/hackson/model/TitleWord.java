package jp.go.ndl.hackson.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import jp.go.ndl.hackson.io.db.DBStringUtil;

public class TitleWord {

	public static final Random seed = new Random();

	private String id;
	private String title;
	private String titleReading;
	private String ndc;
	private String author;

	private int valueCount;
	private int readingCount;

	public TitleWord(String id, String title, String titleReading, String ndc,
			String author) {

		this.id = id;
		this.title = StringUtils.deleteWhitespace(title);
		this.titleReading = StringUtils.deleteWhitespace(titleReading);
		this.ndc = ndc;
		this.author = author;

		if (StringUtils.isNotEmpty(title)) {
			valueCount = title.length();
		}
		if (StringUtils.isNotEmpty(titleReading)) {
			readingCount = titleReading.length();
		}

	}

	public String createHint() {

		String hintTemplate = "NDC %sに所属する%sによる書誌のタイトル";

		return String.format(hintTemplate, ndc, author);
	}

	public String getTitleReading() {
		return titleReading;
	}

	public void setTitleReading(String titleReading) {
		this.titleReading = titleReading;
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
