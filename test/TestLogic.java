import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestLogic extends TestCase{
	Cat cat = new Cat();
	Dog dog = new Dog();
	
	@Test
	public void testStartingCatAge() {
		assertTrue(cat.getAge() >= 5);
		assertTrue(cat.getAge() <= 10);
	}
	
	@Test
	public void testStartingDogAge() {
		assertTrue(dog.getAge() >= 5);
		assertTrue(dog.getAge() <= 10);
	}
	
	@Test
	public void testStartingCatName() {
		assertEquals("", cat.getName());
	}
	
	@Test
	public void testStartingDogName() {
		assertEquals("", dog.getName());
	}

	@Test
	public void testCatSetName() {
		String name1 = "test name 1";
		String name2 = "test name 2";
		String rand = "rand";
		
		//Test setting own name
		cat.setName(name1, null, cat);
		assertEquals("test name 1", cat.getName());
		cat.setName(name2, null, cat);
		assertEquals("test name 2", cat.getName());
		
		//Test setting random name
		cat.setName(name1, null, cat);
		cat.setName(rand, null, cat);
		assertNotEquals(name1, cat.getName());
		cat.setName(name2, null, cat);
		cat.setName(rand, null, cat);
		assertNotEquals(name2, cat.getName());
		
		//Test keeping name same
		cat.setName("test", null, cat);
		cat.setName(null, null, cat);
		assertEquals("test", cat.getName());
		cat.setName("testing", null, cat);
		cat.setName(null, null, cat);
		assertEquals("testing", cat.getName());
	}
	
	@Test
	public void testDogSetName() {
		String name1 = "test name 1";
		String name2 = "test name 2";
		String rand = "rand";
		
		//Test setting own name
		dog.setName(name1, null, dog);
		assertEquals("test name 1", dog.getName());
		dog.setName(name2, null, dog);
		assertEquals("test name 2", dog.getName());
		
		//Test setting random name
		dog.setName(name1, null, dog);
		dog.setName(rand, null, dog);
		assertNotEquals(name1, dog.getName());
		dog.setName(name2, null, dog);
		dog.setName(rand, null, dog);
		assertNotEquals(name2, dog.getName());
		
		//Test keeping name same
		dog.setName("test", null, dog);
		dog.setName(null, null, dog);
		assertEquals("test", dog.getName());
		dog.setName("testing", null, dog);
		dog.setName(null, null, dog);
		assertEquals("testing", dog.getName());
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
	public void testDogSetFavFood() {
		String food1 = "test food 1";
		String food2 = "test food 2";
		String rand = "rand";
		
		//Test setting own food
		dog.setFavFood(food1);
		assertEquals("test food 1", dog.getFavFood());
		dog.setFavFood(food2);
		assertEquals("test food 2", dog.getFavFood());
		
		//Test setting random food
		dog.setFavFood(food1);
		dog.setFavFood(rand);
		assertNotEquals(food1, dog.getFavFood());
		dog.setFavFood(food2);
		dog.setFavFood(rand);
		assertNotEquals(food2, dog.getFavFood());
		
		//Test keeping name food
		dog.setFavFood("test");
		dog.setFavFood(null);
		assertEquals("dog food", dog.getFavFood());
		dog.setFavFood("testing");
		dog.setFavFood(null);
		assertEquals("dog food", dog.getFavFood());
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
	
	@Test
	public void testDogSpeak() {
		String bark1 = "test speak 1";
		String bark2 = "test speak 2";
		String rand = "rand";
		
		//Test setting own speak
		dog.speak(bark1);
		assertEquals("test speak 1", dog.getSpeak());
		dog.speak(bark2);
		assertEquals("test speak 2", dog.getSpeak());
		
		//Test setting random speak
		dog.speak(bark1);
		dog.speak(rand);
		assertNotEquals(bark1, dog.getSpeak());
		dog.speak(bark2);
		dog.speak(rand);
		assertNotEquals(bark2, dog.getSpeak());
				
		//Test keeping name speak
		dog.speak("test");
		dog.speak(null);
		assertEquals("woof, woof", dog.getSpeak());
		dog.speak("testing");
		dog.speak(null);
		assertEquals("woof, woof", dog.getSpeak());
	}
}