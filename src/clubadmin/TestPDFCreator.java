package clubadmin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPDFCreator {
	
	private PDFCreator pdfCr;

	@Before
	public void setUp() throws Exception {
		pdfCr = new PDFCreator(new Member("Otto",27));
	}

	@Test
	public void test() {
		pdfCr.listMember();
		pdfCr.listContentMap();
		
	}

}
