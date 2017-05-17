package clubadmin;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PDFCreator {
	ContentProvider cProvider;
	
	public PDFCreator(ContentProvider cProv){
		this.cProvider= cProv;	
	}
	
	public void setCProvider(ContentProvider cProv){
		this.cProvider= cProv;
	}
	
	public void listMember(){
		Map<String,String> cMap = cProvider.getContentMap();
		System.out.println("Name: " + cMap.get("Name") +
				" Alter: " + cMap.get("Alter"));
	}
	
	public void listContentMap(){
		Map<String,String> cMap = cProvider.getContentMap();
		Set<String> kSet= cMap.keySet();
		Iterator<String> kSetIterator = kSet.iterator();
		while(kSetIterator.hasNext()){
			String key = kSetIterator.next();
			System.out.println(key +": " + cMap.get(key));
		}
		
	
	}

}
