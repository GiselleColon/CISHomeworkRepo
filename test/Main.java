import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Scanner;

public class Main {
	public static Cat cat = new Cat();
	public static Scanner sc = new Scanner(System.in);
	
	public static void unitTesting() {
		System.out.println("-----------Unit Testing----------");
		Result result = JUnitCore.runClasses(TestLogic.class);
						
		for(Failure failure : result.getFailures()) {
			System.out.println("There are some issues here:");
			System.out.println(failure.toString());
		}
				
		System.out.println("Everything successful:");
		System.out.println(result.wasSuccessful());
		System.out.println("---------------------------------");
	}
	
	public static void catIntro() {
		System.out.println("\nMeet your new cat!");
		System.out.println("They are " + cat.getAge() + " years old.");
		System.out.println("Name is currently " + cat.getName());
		cat.setName("Garfield");
		System.out.println("Name has been changed to " + cat.getName() + ".");
	}
	
	public static void catName() {
		String input_name = "";
		
		System.out.println("\nYou can enter your own name now.");
		System.out.println("Alternatively we can randomly pick one for you, just say random.");
		System.out.println("If you'd like to keep it the same, just say no.");
		
		input_name = sc.nextLine();
		
		if(input_name.equalsIgnoreCase("random")) {
			cat.setName("rand");
			System.out.println("Your cat's new name is " + cat.getName() + ".");
		} else if(input_name.equalsIgnoreCase("no")) {
			System.out.println("Okay we'll keep the same name, " + cat.getName() + ".");
		} else {
			cat.setName(input_name);
			System.out.println("You have changed your cats name to " + cat.getName() + ".");
		}
	}
	
	public static void catFavFood() {
		String input_food = "";
		
		System.out.println("\nWhat would you like " + cat.getName() + "'s favorite food to be?");
		System.out.println("You can let us pick a favorite food for you, just say random");
		System.out.println("If you'd like just some generic cat food, just say no");
		
		input_food = sc.nextLine();
		
		if(input_food.equalsIgnoreCase("random")) {
			cat.setFavFood("rand");
			System.out.println(cat.getName() + "'s new favorite food is " + cat.getFavFood() + ".");
		} else if(input_food.equalsIgnoreCase("no")) {
			cat.setFavFood(null);
			System.out.println("Okay " + cat.getName() + " will just enjoy " + cat.getFavFood() + ".");
		} else {
			cat.setFavFood(input_food);
			System.out.println(cat.getName() + "'s favorite food is " + cat.getFavFood() + ".");
		}
	}
	
	public static void catSpeak() {
		String input_speak = "";
		
		System.out.println("\nDoes your cat, " + cat.getName() + ", go nya, mau, or something else?");
		System.out.println("You can let us pick a meow for you cat, just say random.");
		System.out.println("If you'd like generic meowing, just say no.");
		
		input_speak = sc.nextLine();
		
		if(input_speak.equalsIgnoreCase("random")) {
			cat.speak("rand");
			//System.out.println("Your cat now goes " + cat.speak + ".");
		} else if(input_speak.equalsIgnoreCase("no")) {
			System.out.println("Okay we'll give " + cat.getName() + " the generic meow.");
			cat.speak(null);
		} else {
			System.out.println("You have decided to have " + cat.getName() + " go " + input_speak + ".");
			cat.speak(input_speak);
		}
		
		try {
    		while(true) {
    			String meow = cat.getSpeak();
    			int time = 10 * 1000;
    			
    			Thread.sleep(time);
    			cat.speak(meow);
    		}
    	} catch(InterruptedException ex) {
    		ex.printStackTrace();
    	}
	}
	
	public static void main(String[] args) {
		unitTesting();
		
		catIntro();
		
		catName();
		
		catFavFood();
		
		catSpeak();
		
//		data = new Data("database")
//
//		data.insert("Cat", cat);
	}

}
