package jp.go.ndl.hackson.harvest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;
import org.z3950.zing.cql.CQLNode;

import jp.go.ndl.hackson.model.TitleWord;
import jp.go.ndl.hackson.model.WordList;

import com.yurugee.lib.ndlapi.exception.ConfigurationException;
import com.yurugee.lib.ndlapi.sru.SruAccess;
import com.yurugee.lib.ndlapi.sru.request.SruRequest;
import com.yurugee.lib.ndlapi.sru.request.SruRequest.Version;
import com.yurugee.lib.ndlapi.sru.request.item.CQLFactory;
import com.yurugee.lib.ndlapi.sru.request.item.CQLFactory.ItemType;
import com.yurugee.lib.ndlapi.sru.request.item.CQLFactory.ListCondition;
import com.yurugee.lib.ndlapi.sru.request.item.CQLFactory.MatchCondition;
import com.yurugee.lib.ndlapi.sru.response.SruResponse;

public class SruHarvest {
	
	public List<TitleWord> harvest(List<WordList> keywords,int start,int end) throws ConfigurationException, NumberFormatException, UnsupportedOperationException, UnsupportedEncodingException, XPathExpressionException, IOException, SAXException{
		
		List<TitleWord> result = new ArrayList<TitleWord>();
		
		for(int i = start;i<end;i++){
			
			WordList word = keywords.get(i);
			List<String> words = new ArrayList<String>();
			words.add(word.getValue());
			
			CQLNode node = CQLFactory.createCQLNode(ItemType.TITLE,
					MatchCondition.NONE, ListCondition.EQUAL, words);
			
			SruRequest request = new SruRequest();
			
			request.setVersion(Version.VER_1_2);
			request.setCql(node);
			
			SruResponse res = SruAccess.send(request);
			
			result.addAll(convert(res));
			
		}

		return result;
	}

	private Collection<? extends TitleWord> convert(SruResponse res) {
		
		
		
		return null;
	}
	
	
	
	
	
	
	
	

}
