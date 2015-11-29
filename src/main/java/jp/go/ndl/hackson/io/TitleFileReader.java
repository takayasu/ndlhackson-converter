package jp.go.ndl.hackson.io;

import jp.go.ndl.hackson.model.TitleWord;

public class TitleFileReader extends AbstractReader<TitleWord> {
	
//	public List<TitleWord> read(String file) throws IOException {
//
//		List<TitleWord> list = new ArrayList<TitleWord>();
//		
//		if(StringUtils.isEmpty(file)){
//			System.err.println("FilePath is not string.");
//			return list;
//		}
//		
//		File f = new File(file);
//		
//		LineIterator it = FileUtils.lineIterator(f, "UTF-8");
//		
//		try{
//			while(it.hasNext()){
//				list.add(createOne(it.nextLine()));
//			}
//			
//		}finally{
//			it.close();
//		}
//		
//
//		return list;
//	}
	
	/**
	 * URL
     * "ndl_iss/bibResource/title/value",
     * "ndl_iss/bibResource/title/transcription",
     * "ndl_iss/bibAdminResource@issId",
     * "ndl_iss/bibResource/responsibility",
     * "ndl_iss/bibResource/publisher/name",
     * "ndl_iss/bibResource/classification@resource=NDC9",
     * "ndl_iss/bibResource/publicationDate",
     * "ndl_iss/bibResource/bibIdentifier@datatype=ISBN"
	 * @param line
	 * @return
	 */
	
	@Override
	public TitleWord createOne(String line){
				
		String[] items = line.split("\t");
		
		String title = items[1];
		String titleReading = items[2];
		String id = items[3];
		String author = items[4];
		String ndc = items[6];

		TitleWord word = new TitleWord(id,title,titleReading,ndc,author);
		
		return word;
		
	}
	

}
