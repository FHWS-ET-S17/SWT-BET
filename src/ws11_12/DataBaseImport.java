package ws11_12;

import java.util.ArrayList;
import java.util.List;


public class DataBaseImport {

	// Diese Konstruktion ist nur zur einfachen Erzeugung der
	// DisplayElementObjekte
	// Das würde in der Realität natürlich anders aussehen
	
	private static enum Type {PLC,Diagram};

	private static String[][] plcArray = { 
			{ "PLC1", "Dia1", "Dia3", "Dia7" }, 
			{ "PLC2", "Dia1", "Dia4", null },
			{ "PLC3", "Dia1", "Dia3", "Dia6" }};
												
	
	private static String[][] diagramArray = {  
			{ "Dia1", "PLC2", "PLC3", null }, 
			{ "Dia3", "PLC1", null, null },	
			{ "Dia4", "PLC3", null }, 
			{ "Dia6", "PLC2", "PLC3", null}, 
			{ "Dia7", "PLC2", null, null } };

   	
	private static List<String> createAssociatedElementList(String[] names){
	   List<String> associatedElements = new ArrayList<>();
	   for (int j = 1; j < names.length; j++) {
			String associatedElement = names[j];
			if (associatedElement == null)
				break;
			associatedElements.add(associatedElement);
		}
	   return associatedElements;
   }
	
	
	public static List<PLC> loadPlcs() {
		List<PLC> dList = new ArrayList<>();
		for (int i = 0; i < plcArray.length; i++) {
			String elName =plcArray[i][0];
			PLC plc = new PLC (elName);
			
			plc.setAssociatedNames(createAssociatedElementList(plcArray[i]));
			dList.add(plc);
		}
		return dList;
	}
	
	public static List<Diagram> loadDiagrams() {
		List<Diagram> dList = new ArrayList<>();
		for (int i = 0; i < diagramArray.length; i++) {
			String elName =diagramArray[i][0];
			Diagram diagram  = new Diagram(elName);
			
			diagram.setAssociatedNames(createAssociatedElementList(diagramArray[i]));
			dList.add(diagram);
		}
		return dList;
	}
	

}
