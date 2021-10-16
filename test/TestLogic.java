import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestLogic extends TestCase{
	Cat cat = new Cat();
	
	@Test
	public void testStartingCatAge() {
		assertTrue(cat.getAge() >= 5);
		assertTrue(cat.getAge() <= 10);
	}
	
	@Test
	public void testStartingCatName() {
		assertEquals("", cat.getName());
	}

	@Test
	public void testCatSetName() {
		String name1 = "test name 1";
		String name2 = "test name 2";
		String rand = "rand";
		
		//Test setting own name
		cat.setName(name1);
		assertEquals("test name 1", cat.getName());
		cat.setName(name2);
		assertEquals("test name 2", cat.getName());
		
		//Test setting random name
		cat.setName(name1);
		cat.setName(rand);
		assertNotEquals(name1, cat.getName());
		cat.setName(name2);
		cat.setName(rand);
		assertNotEquals(name2, cat.getName());
		
		//Test keeping name same
		cat.setName("test");
		cat.setName(null);
		assertEquals("test", cat.getName());
		cat.setName("testing");
		cat.setName(null);
		assertEquals("testing", cat.getName());
	}
	
	@Test
	public void testCatSetFavFood() {
		String food1 = "test food 1";
		String food2 = "test food 2";
		String rand = "rand";
		
		//Test setting own food
		cat.setFavFood(food1);
		assertEquals("test food 1", cat.getFavFood());
		cat.setFavFood(food2);
		assertEquals("test food 2", cat.getFavFood());
		
		//Test setting random food
		cat.setFavFood(food1);
		cat.setFavFood(rand);
		assertNotEquals(food1, cat.getFavFood());
		cat.setFavFood(food2);
		cat.setFavFood(rand);
		assertNotEquals(food2, cat.getFavFood());
		
		//Test keeping name food
		cat.setFavFood("test");
		cat.setFavFood(null);
		assertEquals("cat food", cat.getFavFood());
		cat.setFavFood("testing");
		cat.setFavFood(null);
		assertEquals("cat food", cat.getFavFood());
	}
	
	@Test
	public void testCatSpeak() {
		String meow1 = "test speak 1";
		String meow2 = "test speak 2";
		String rand = "rand";
		
		//Test setting own speak
		cat.speak(meow1);
		assertEquals("test speak 1", cat.getSpeak());
		cat.speak(meow2);
		assertEquals("test speak 2", cat.getSpeak());
		
		//Test setting random speak
		cat.speak(meow1);
		cat.speak(rand);
		assertNotEquals(meow1, cat.getSpeak());
		cat.speak(meow2);
		cat.speak(rand);
		assertNotEquals(meow2, cat.getSpeak());
				
		//Test keeping name speak
		cat.speak("test");
		cat.speak(null);
		assertEquals("meow", cat.getSpeak());
		cat.speak("testing");
		cat.speak(null);
		assertEquals("meow", cat.getSpeak());
	}
}