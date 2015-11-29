package jp.go.ndl.hackson.model.text;

import java.util.ArrayList;
import java.util.List;

import jp.go.ndl.hackson.model.CommonData;

public class CommonDataForText implements TextOutputModel {
	
	private CommonData target;
	

	public CommonDataForText(CommonData target) {
		super();
		this.target = target;
	}



	public List<String> outputLine() {
		List<String> result = new ArrayList<String>();
		result.add(target.getKeyword());
		result.add(target.getHint());
		
		return result;
	}

}
