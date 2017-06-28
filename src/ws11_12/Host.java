package ws11_12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Host {
	
	protected Map<String, DisplayElement> elements;
	
	public Host(){
		elements = new HashMap<>();
		loadPLCs();
		this.loadPDiagrams();
		try{
			this.linkDisplayElements();
		} catch(NoDisplayElementException ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void loadPLCs(){
		List<PLC> plcList = DataBaseImport.loadPlcs();
		Iterator<PLC> plcIt = plcList.iterator();
		while (plcIt.hasNext()){
			PLC plc = plcIt.next();
			elements.put(plc.getName(), plc);
		}
	}
	
	public void loadPDiagrams(){
		for (Diagram dia : DataBaseImport.loadDiagrams()){
			elements.put(dia.getName(), dia);
		}
	}
	
	public void linkDisplayElements() throws NoDisplayElementException{
		Iterator<DisplayElement> deIt = elements.values().iterator();
		while (deIt.hasNext()){
			DisplayElement de = deIt.next();
			List<String> elNames = de.getAssociatedNames();
			for (String name: elNames){
				if (!elements.containsKey(name)){
					throw new NoDisplayElementException("Element nicht vorhanden: " + name);
				}
				DisplayElement el = elements.get(name);
				//if (el==null){
				//throw new NoDisplayElementException("Element nicht vorhanden: " + name);
				//}
				try{
					de.link(el);
				} catch (NullPointerException ex){
					throw new NoDisplayElementException("Element nicht vorhanden: " + name);
					
				} catch (Exception ex){
					
				}
			}
			
		}
		
	}
	
	
}
