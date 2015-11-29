package datainput;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringTest {

	@Test
	public void test() {
		
		String data = "　テスト　テスト テスト ";
		
		String test = StringUtils.deleteWhitespace(data);
		
		assertEquals("テストテストテスト",test);
		
	}

}
