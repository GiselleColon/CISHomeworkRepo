//import static org.junit.jupiter.api.Assertions.*;
import junit.framework.TestCase;

import org.junit.Test;

public class MainTest extends TestCase {
	protected String str;
	protected int num;
	protected String null_str;
	
	@Test
	public void test() {
		str = "Junit is working fine";
		num = 5;
		null_str = null;
		
		//System.out.println("Number of Test Cases: " + this.countTestCases());
		
//		assertEquals("Junit is working fine",str);
//		assertFalse(num > 6);
//		assertNotNull(null_str);
	}
	
	public void tearDown() {
		
	}

}
