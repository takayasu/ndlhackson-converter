package jp.go.ndl.hackson.io.text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.go.ndl.hackson.model.CommonData;
import jp.go.ndl.hackson.model.text.CommonDataForText;

import org.apache.commons.io.FileUtils;

public class TextDataWriter {
	
	public static void write(String path,List<CommonData> list) throws IOException{
		
//		List<Object> lineMergeData = list.stream().map(new Function<CommonData, List<String>>() {
//
//			public List<String> apply(CommonData t) {
//				CommonDataForData proxy = new CommonDataForData(t);
//				return proxy.outputLine();
//			}
//		}).collect(Collectors.toList());
		
		List<String> lines = new ArrayList<String>();
		
		for(CommonData data: list){
			CommonDataForText proxy = new CommonDataForText(data);
			lines.addAll(proxy.outputLine());
		}
		
		int size = lines.size()/2;

		lines.add(0, String.valueOf(size));
		
		FileUtils.writeLines(new File(path), lines);
		
		
	}
	

}
