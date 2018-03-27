package snippets;

import java.util.HashMap;
import java.util.Map;

public class ParaMap {
	
	private static Map<String,Object> pMap = new HashMap<>();
	private static Map<String,String> pSMap = new HashMap<>();

	public static void main(String[] args) throws Exception{
		if (!pMap.containsKey("treshhold"));
		try{
			pMap.put("treshhold", new Double(17));
			pSMap.put("treshhold", "17");
			Integer i2 = (Integer) pMap.get("treshhold");
			Integer i3 = Integer.parseInt(pSMap.get("treshhold"));
		} catch (Exception ex){
			throw new Exception("treshhold war kein Int");
		}

	}

}
