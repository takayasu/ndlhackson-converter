package jp.go.ndl.hackson.io.db;

public class DBStringUtil {

	public static String phaseString(String[] list){
		String link = String.join(",", list);
		
		StringBuilder build = new StringBuilder();
		
		build.append("(");
		build.append(link);
		build.append(")");
		
		return build.toString();
		
	}
	
	public static String convertSinglePhase(String data) {
		return "'" + data + "'";
	}
	
}
