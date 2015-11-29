package jp.go.ndl.hackson.model.text;

import java.util.ArrayList;
import java.util.List;

import jp.go.ndl.hackson.model.TitleWord;

public class TitleWordForText implements TextOutputModel {
	
	private TitleWord target;
	
	public TitleWordForText(TitleWord title){
		target = title;
	}

	public List<String> outputLine(){
		List<String> result = new ArrayList<String>();
		result.add(target.getTitleReading());
		result.add(target.createHint());
		
		return result;
		
	}

}
