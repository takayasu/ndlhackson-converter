package datainput;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LabSearchTest {
	
	String url = "http://lab.ndl.go.jp/ndls/api/search2/select?q=";

	@Test
	public void test() throws UnsupportedOperationException, IOException {
		String titleName = "title_morph_text";
		String title = "夏目漱石";
		
		String request = url + titleName + ":" + title;
		
		String result = send(request);
		
		System.out.println(result);
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Integer> map = mapper.readValue(result, Map.class);
		
		System.out.println("");
		
		
	}
	
	public String send(String url) throws UnsupportedOperationException, IOException{
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
	 
		HttpResponse response = client.execute(request);
	 	 
		BufferedReader rd = new BufferedReader(
			new InputStreamReader(response.getEntity().getContent()));
	 
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		
		return result.toString();
		
	}
	
	

}
