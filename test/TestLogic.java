import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestLogic extends TestCase{
	Cat cat = new Cat();
	
	@Test
	public void testStartingCatAge() {
		assertTrue(cat.getAge() >= 5);
		assertTrue(cat.getAge() <= 10);
		
		//System.out.println("Starting cat age tested.");
	}
	
	@Test
	public void testStartingCatName() {
		assertEquals("", cat.getName());
		
		//System.out.println("Starting cat name tested.");
	}

	@Test
	public void testCatSetName() {
		String name1 = "test name 1";
		String name2 = "test name 2";
		
		//"Correct" Tests
		cat.setName(name1);
		assertEquals("test name 1", cat.getName());
		cat.setName(name2);
		assertEquals("test name 2", cat.getName());
		//"Breaking" Tests
		cat.setName(name1);
		assertNotEquals("test", cat.getName());
		cat.setName(name2);
		assertNotEquals("test", cat.getName());
		
		//System.out.println("Set cat name tested.");
	}
	
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Find better test, this one sometimes gives a false negative
	@Test
	public void testCatSetRandName() {
		cat.setRandName();
		String name1 = cat.getName();
		cat.setRandName();
		String name2 = cat.getName();
		cat.setRandName();
		String name3 = cat.getName();

		assertNotSame(name1, name2);
		assertNotSame(name2, name3);
		assertNotSame(name3, name1);
		
		//System.out.println("Set cat random name tested.");
	}
	
	@Test
	public void testCatSpeak() {
		String meow1 = "miau";
		String meow2 = "nya";
		
		//"Correct" Tests
		cat.speak(null);
		assertEquals("meow", cat.getSpeak());
		cat.speak(meow1);
		assertEquals("miau", cat.getSpeak());
		cat.speak(meow2);
		assertEquals("nya", cat.getSpeak());
		
		//System.out.println("Cat speak tested.");
	}
}
