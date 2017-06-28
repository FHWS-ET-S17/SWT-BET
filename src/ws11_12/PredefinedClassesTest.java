package ws11_12;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class PredefinedClassesTest {
	
	@Test
	public void testObjectCreation(){
		PLC plc = new PLC("PLC");
		assertEquals(plc.getName(), "PLC");
	}
	
	@Test
	public void testImport() {
		List<PLC> plcList = DataBaseImport.loadPlcs();
		List<Diagram> diagramList = DataBaseImport.loadDiagrams();
		assertEquals(plcList.size(), 3);
		assertEquals(diagramList.size(), 5);
		
		for (PLC plc: plcList){
			if (plc.getName().equals("PLC1")){
				assertEquals(plc.getAssociatedNames().size(),3);
				assertTrue(plc.getAssociatedNames().contains("Dia1"));
				assertTrue(plc.getAssociatedNames().contains("Dia3"));
				assertTrue(plc.getAssociatedNames().contains("Dia7"));
				assertFalse(plc.getAssociatedNames().contains("Dia2"));
				break;
			}
			fail(); // wenn er hier ankommt war PLC1 nicht in der Liste
		}
		
		for (Diagram diagram: diagramList){
			if (diagram.getName().equals("Dia1")){
				assertEquals(diagram.getAssociatedNames().size(),2);
				assertTrue(diagram.getAssociatedNames().contains("PLC2"));
				assertTrue(diagram.getAssociatedNames().contains("PLC3"));
				
				break;
			}
			fail(); // wenn er hier ankommt war Dia1 nicht in der Liste
		}
	}

	
	@Test
	public void testLinkMethod(){
		List<PLC> plcList = DataBaseImport.loadPlcs();
		List<Diagram> diagramList = DataBaseImport.loadDiagrams();
		PLC plc = plcList.get(0);
		Diagram diagram1 = diagramList.get(0);
		Diagram diagram2 = diagramList.get(1);
		Diagram diagram3 = diagramList.get(2);
		plc.link(diagram1);
		plc.link(diagram2);
		assertTrue(plc.isLinkedWith(diagram1.getName()));
		assertTrue(plc.isLinkedWith(diagram2.getName()));
		assertFalse(plc.isLinkedWith(diagram3.getName()));
		try{
			plc.link(null);
			fail("Sollte NP-Ex werfen");
		}catch (NullPointerException ex){
			
		}catch (Exception ex){
			fail("Unerwartete Exception: " + ex.getClass().getSimpleName());
			
		}
	}
	

	@Test
	public void testGetType(){
		PLC plc = new PLC("PLC1");
		Diagram dia = new Diagram("Dia1");
		
		assertEquals("PLC1", plc.getName());
		assertEquals("Dia1",dia.getName());
		
	}
	
	@Test
	public void testLoadPlcs(){
		Host myHost = new Host();
		List<PLC> plcList = DataBaseImport.loadPlcs();
		Map<String, DisplayElement> myMap = myHost.elements;
		for (DisplayElement de: plcList){
			assertTrue(myMap.containsKey(de.getName()));
			assertEquals(de.getName(), myMap.get(de.getName()).getName());
		}
	}
	
	@Test
	public void testLinkDiplayElements(){
		Host myHost = new Host();
		DisplayElement plc1 = myHost.elements.get("PLC1");
		assertTrue(plc1.isLinkedWith("Dia1"));
		assertTrue(plc1.isLinkedWith("Dia3"));
		assertFalse(plc1.isLinkedWith("Dia5"));
		
	}
	
	
	
	
	
	
	
	
	
	
}
