import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//Test Runner
		System.out.println("-----------Unit Testing----------");
		Result result = JUnitCore.runClasses(TestLogic.class);
				
		for(Failure failure : result.getFailures()) {
			System.out.println("There are some issues here:");
			System.out.println(failure.toString());
		}
		
		System.out.println("Everything successful:");
		System.out.println(result.wasSuccessful());
		System.out.println("---------------------------------");
		//End Test Runner
		
		Cat cat = new Cat();
		Scanner sc = new Scanner(System.in);
		String input_name = "";
		
		System.out.println("\nMeet your new cat!");
		System.out.println("They are " + cat.age + " years old.");
		System.out.println("Name is currently " + cat.name);
		cat.setName("Garfield");
		System.out.println("Name has been changed to " + cat.name + ".");
		System.out.println("\nYou can enter your own name now.");
		System.out.println("Alternatively we can randomly pick one for you, just say random.");
		System.out.println("If you'd like to keep it the same, just say no.");
		
		input_name = sc.nextLine();
		
		if(input_name.equalsIgnoreCase("random")) {
			cat.setRandName();
			System.out.println("Your cats new name is " + cat.name + ".");
		} else if(input_name.equalsIgnoreCase("no")) {
			System.out.println("Okay we'll keep the same name, " + cat.name + ".");
		} else {
			cat.setName(input_name);
			System.out.println("You have changed your cats name to " + cat.name + ".");
		}
		
//
//		data = new Data("database")
//
//		data.insert("Cat", cat);
	}

}
