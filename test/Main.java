import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Scanner;

public class Main {
	public static Cat cat = new Cat();
	public static Dog dog = new Dog();
	public static Scanner sc = new Scanner(System.in);
	public static Data db = new Data();
	static String animal = "";
	static PopUpWindows puw = new PopUpWindows();
	static boolean cont = true;
	
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
	
	public static void dbConnect() {
		db.connect();
		db.createTables();
	}
	
	public static void dataTasks() {
		System.out.println("-----------Data Tasks----------");
		DataTasks dt = new DataTasks(db);
		dt.savePetShop(db);
		System.out.println("---------------------------------");
	}
	
	public static void chooseAnimal() {
//		System.out.println("\nAre you looking for a cat or a dog?");
		int input = -1;
		
		input = puw.customButtonDialog("Are you looking for a cat or a dog?", null, null, false, "Cat", "Dog", "Cancel");
		
//		animal = sc.nextLine();
		
		if(input == 1) {
			animal = "cat";
		} else if(input == 2) {
			animal = "dog";
		} else if(input == 3) {
			puw.showDialog("Program is now terminating.");
			db.closeConnection();
			System.exit(0);
		}
		
//		if(!animal.equalsIgnoreCase("cat") && !animal.equalsIgnoreCase("dog")) {
//			System.out.println("It looks like you didn't enter cat or dog.");
//			System.out.println("Program is now terminating.");
//			
//			db.closeConnection();
//			System.exit(0);
//		}
	}
	
	public static void animalIntro() {
//		System.out.println("\nMeet your new "+ animal.toLowerCase() + "!");
		String label = "Meet your new "+ animal.toLowerCase() + "!";
		puw.showDialog(label);
		
		if(animal.equalsIgnoreCase("cat")) {
//			System.out.println("They are " + cat.getAge() + " years old.");
			System.out.println("Name is currently " + cat.getName());
			String age = "They are " + cat.getAge() + " years old.";
			
			puw.showDialog(age);
			
			cat.start(db, cat);
			cat.setName("Garfield", db, cat);
			
			String name = "Their name is " + cat.getName();
			
			puw.showDialog(name);
			
			System.out.println("Name has been changed to " + cat.getName() + ".");
		} else if(animal.equalsIgnoreCase("dog")) {
//			System.out.println("They are " + dog.getAge() + " years old.");
			System.out.println("Name is currently " + dog.getName());
			String age = "They are " + dog.getAge() + " years old.";
			
			puw.showDialog(age);
			
			dog.start(db, dog);
			dog.setName("Spot", db, dog);
			
			String name = "Their name is " + dog.getName();
			
			puw.showDialog(name);
			System.out.println("Name has been changed to " + dog.getName() + ".");
		}
	}
	
	public static void animalName() {
		String input_name = "";
		int input = -1;
		String label1 = "You can enter your own name now, then click Text.";
		String label2 = "\nAlternatively we can randomly pick one for you, just click Random.";
		String label3 = "\nIf you'd like to keep it the same, just click Default.";
		String output = "";
		
//		System.out.println("\nYou can enter your own name now.");
//		System.out.println("Alternatively we can randomly pick one for you, just say random.");
//		System.out.println("If you'd like to keep it the same, just say no.");
		
		input = puw.customButtonDialog(label1, label2, label3, true, "Text", "Random", "Default");
		
//		input_name = sc.nextLine();
		
		if(input == 1) {
			input_name = puw.getTextFieldText();
			
			if(animal.equalsIgnoreCase("cat")) {
				cat.setName(input_name, db, cat);
				output = "You have changed your cat's name to " + cat.getName() + ".";
			} else if(animal.equalsIgnoreCase("dog")) {
				dog.setName(input_name, db, dog);
				output = "You have changed your dog's name to " + dog.getName() + ".";
			}
		} else if(input == 2) {
			if(animal.equalsIgnoreCase("cat")) {
				cat.setName("rand", db, cat);
				output = "Your cat's new name is " + cat.getName() + ".";
			} else if(animal.equalsIgnoreCase("dog")) {
				dog.setName("rand", db, dog);
				output = "Your dog's new name is " + dog.getName() + ".";
			}
		} else if(input == 3) {
			if(animal.equalsIgnoreCase("cat")) {
				output = "Okay we'll keep the same name, " + cat.getName() + ".";
			} else if(animal.equalsIgnoreCase("dog")) {
				output = "Okay we'll keep the same name, " + dog.getName() + ".";
				
			}
		}
		
		puw.showDialog(output);
		
//		if(input_name.equalsIgnoreCase("random")) {
//			if(animal.equalsIgnoreCase("cat")) {
//				cat.setName("rand", db, cat);
//				System.out.println("Your cat's new name is " + cat.getName() + ".");
//			} else if(animal.equalsIgnoreCase("dog")) {
//				dog.setName("rand", db, dog);
//				System.out.println("Your dog's new name is " + dog.getName() + ".");
//			}
//		} else if(input_name.equalsIgnoreCase("no")) {
//			if(animal.equalsIgnoreCase("cat")) {
//				System.out.println("Okay we'll keep the same name, " + cat.getName() + ".");
//			} else if(animal.equalsIgnoreCase("dog")) {
//				System.out.println("Okay we'll keep the same name, " + dog.getName() + ".");
//			}
//		} else {
//			if(animal.equalsIgnoreCase("cat")) {
//				cat.setName(input_name, db, cat);
//				System.out.println("You have changed your cat's name to " + cat.getName() + ".");
//			} else if(animal.equalsIgnoreCase("dog")) {
//				dog.setName(input_name, db, dog);
//				System.out.println("You have changed your dog's name to " + dog.getName() + ".");
//			}
//		}
		
		String[] names = null;
		
		if(animal.equalsIgnoreCase("cat")) {
			names = cat.getNames(db);
		} else if(animal.equalsIgnoreCase("dog")) {
			names = dog.getNames(db);
		}
		
		System.out.println("\nHere are all the names your " + animal.toLowerCase() + " has had so far:");
		
		for(int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
		
		System.out.println("The average length of the names is " + db.getAverageNameLength(animal.toLowerCase()) + ".");
	}
	
	public static void animalFavFood() {
		String input_food = "";
		int input = -1;
		String label1 = "";
		
		if(animal.equalsIgnoreCase("cat")) {
//			System.out.println("\nWhat would you like " + cat.getName() + "'s favorite food to be?");
			label1 = "What would you like " + cat.getName() + "'s favorite food to be? Click Text.";
		} else if(animal.equalsIgnoreCase("dog")) {
//			System.out.println("\nWhat would you like " + dog.getName() + "'s favorite food to be?");
			label1 = "What would you like " + dog.getName() + "'s favorite food to be? Click Text.";
		}
		
//		System.out.println("You can let us pick a favorite food for you, just say random");
//		System.out.println("If you'd like just some generic cat food, just say no");
		String label2 = "You can let us pick a favorite food for you, just click Random";
		String label3 = "If you'd like just some generic cat food, just click Default";
		String output = "";
		
//		input_food = sc.nextLine();
		input = puw.customButtonDialog(label1, label2, label3, true, "Text", "Random", "Default");
		
		if(input == 1) {
			input_food = puw.getTextFieldText();
			
			if(animal.equalsIgnoreCase("cat")) {
				cat.setFavFood(input_food);
				output = cat.getName() + "'s favorite food is " + cat.getFavFood() + ".";
			} else if(animal.equalsIgnoreCase("dog")) {
				dog.setFavFood(input_food);
				output = dog.getName() + "'s favorite food is " + dog.getFavFood() + ".";
			}
		} else if(input == 2) {
			if(animal.equalsIgnoreCase("cat")) {
				cat.setFavFood("rand");
				output = cat.getName() + "'s new favorite food is " + cat.getFavFood() + ".";
			} else if(animal.equalsIgnoreCase("dog")) {
				dog.setFavFood("rand");
				output = dog.getName() + "'s new favorite food is " + dog.getFavFood() + ".";
			}
		} else if(input == 3) {
			if(animal.equalsIgnoreCase("cat")) {
				cat.setFavFood(null);
				output = "Okay " + cat.getName() + " will just enjoy " + cat.getFavFood() + ".";
			} else if(animal.equalsIgnoreCase("dog")) {
				dog.setFavFood(null);
				output = "Okay " + dog.getName() + " will just enjoy " + dog.getFavFood() + ".";
			}
		}
		
		puw.showDialog(output);
		
//		if(input_food.equalsIgnoreCase("random")) {
//			if(animal.equalsIgnoreCase("cat")) {
//				cat.setFavFood("rand");
//				System.out.println(cat.getName() + "'s new favorite food is " + cat.getFavFood() + ".");
//			} else if(animal.equalsIgnoreCase("dog")) {
//				dog.setFavFood("rand");
//				System.out.println(dog.getName() + "'s new favorite food is " + dog.getFavFood() + ".");
//			}
//		} else if(input_food.equalsIgnoreCase("no")) {
//			if(animal.equalsIgnoreCase("cat")) {
//				cat.setFavFood(null);
//				System.out.println("Okay " + cat.getName() + " will just enjoy " + cat.getFavFood() + ".");
//			} else if(animal.equalsIgnoreCase("dog")) {
//				dog.setFavFood(null);
//				System.out.println("Okay " + dog.getName() + " will just enjoy " + dog.getFavFood() + ".");
//			}
//		} else {
//			if(animal.equalsIgnoreCase("cat")) {
//				cat.setFavFood(input_food);
//				System.out.println(cat.getName() + "'s favorite food is " + cat.getFavFood() + ".");
//			} else if(animal.equalsIgnoreCase("dog")) {
//				dog.setFavFood(input_food);
//				System.out.println(dog.getName() + "'s favorite food is " + dog.getFavFood() + ".");
//			}
//		}
		
		if(animal.equalsIgnoreCase("cat")) {
			cat.update(db, cat, "favFood");
		} else if(animal.equalsIgnoreCase("dog")) {
			dog.update(db, dog, "favFood");
		}
	}
	
	public static void animalSpeak() {
		String input_speak = "", label1 = "", label2 = "", label3 = "";
		int input = -1;
		String output = "";
		
		if(animal.equalsIgnoreCase("cat")) {
//			System.out.println("\nDoes your cat, " + cat.getName() + ", go nya, mau, or something else?");
//			System.out.println("You can let us pick a meow for you cat, just say random.");
//			System.out.println("If you'd like generic meowing, just say no.");
			label1 = "Does your cat, " + cat.getName() + ", go nya, mau, or something else? Click Text.";
			label2 = "You can let us pick a meow for you cat, just click Random.";
			label3 = "If you'd like generic meowing, just click Default.";
		} else if(animal.equalsIgnoreCase("dog")) {
//			System.out.println("\nDoes your dog, " + dog.getName() + ", go wuff, bow, or something else?");
//			System.out.println("You can let us pick a bark for you dog, just say random.");
//			System.out.println("If you'd like generic barking, just say no.");
			label1 = "Does your dog, " + dog.getName() + ", go wuff, bow, or something else? Click Text.";
			label2 = "You can let us pick a bark for you dog, just click Random.";
			label3 = "If you'd like generic barking, just click Default.";
		}
		
		input = puw.customButtonDialog(label1, label2, label3, true, "Text", "Random", "Default");
		
//		input_speak = sc.nextLine();
		
		if(input == 1) {
			input_speak = puw.getTextFieldText();
			
			if(animal.equalsIgnoreCase("cat")) {
				output = "You have decided to have " + cat.getName() + " go " + input_speak + ".";
				puw.showDialog(output);
				cat.speak(input_speak);
			} else if(animal.equalsIgnoreCase("dog")) {
				output = "You have decided to have " + dog.getName() + " go " + input_speak + ".";
				puw.showDialog(output);
				dog.speak(input_speak);
			}
		} else if(input == 2) {
			if(animal.equalsIgnoreCase("cat")) {
				cat.speak("rand");
				output = "Your cat now goes " + cat.getSpeak() + ".";
			} else if(animal.equalsIgnoreCase("dog")) {
				dog.speak("rand");
				output = "Your dog now goes " + dog.getSpeak() + ".";
			}
			
			puw.showDialog(output);
		} else if(input == 3) {
			if(animal.equalsIgnoreCase("cat")) {
				output = "Okay we'll give " + cat.getName() + " the generic meow.";
				puw.showDialog(output);
				cat.speak(null);
			} else if(animal.equalsIgnoreCase("dog")) {
				output = "Okay we'll give " + dog.getName() + " the generic bark.";
				puw.showDialog(output);
				dog.speak(null);
			}
		}
		
//		if(input_speak.equalsIgnoreCase("random")) {
//			if(animal.equalsIgnoreCase("cat")) {
//				cat.speak("rand");
//				System.out.println("Your cat now goes " + cat.getSpeak() + ".");
//			} else if(animal.equalsIgnoreCase("dog")) {
//				dog.speak("rand");
//				System.out.println("Your dog now goes " + dog.getSpeak() + ".");
//			}
//		} else if(input_speak.equalsIgnoreCase("no")) {
//			if(animal.equalsIgnoreCase("cat")) {
//				System.out.println("Okay we'll give " + cat.getName() + " the generic meow.");
//				cat.speak(null);
//			} else if(animal.equalsIgnoreCase("dog")) {
//				System.out.println("Okay we'll give " + dog.getName() + " the generic bark.");
//				dog.speak(null);
//			}
//		} else {
//			if(animal.equalsIgnoreCase("cat")) {
//				System.out.println("You have decided to have " + cat.getName() + " go " + input_speak + ".");
//				cat.speak(input_speak);
//			} else if(animal.equalsIgnoreCase("dog")) {
//				System.out.println("You have decided to have " + dog.getName() + " go " + input_speak + ".");
//				dog.speak(input_speak);
//			}
//		}
		
		if(animal.equalsIgnoreCase("cat")) {
			cat.update(db, cat, "speak");
		} else if(animal.equalsIgnoreCase("dog")) {
			dog.update(db, dog, "speak");
		}
		
		try {
			if(animal.equalsIgnoreCase("cat")) {
				while(cat.alive) {
	    			String meow = cat.getSpeak();
	    			int sec = 1;
	    			int time = sec * 1000;
	    			int currAge = cat.getAge();
	    			
	    			Thread.sleep(time);
	    			cat.speak(meow);
	    			
	    			if(currAge != cat.getAge()) {
	    				cat.update(db, cat, "age");
	    				currAge = cat.getAge();
	    			}
	    		}
	    		
	    		if(!cat.alive) {
	    			cat.update(db, cat, "death");
	    		}
			} else if(animal.equalsIgnoreCase("dog")) {
				while(dog.alive) {
	    			String bark = dog.getSpeak();
	    			int sec = 1;
	    			int time = sec * 1000;
	    			int currAge = dog.getAge();
	    			
	    			Thread.sleep(time);
	    			dog.speak(bark);
	    			
	    			if(currAge != dog.getAge()) {
	    				dog.update(db, dog, "age");
	    				currAge = dog.getAge();
	    			}
	    		}
	    		
	    		if(!dog.alive) {
	    			dog.update(db, dog, "death");
	    		}
			}
    	} catch(InterruptedException ex) {
    		ex.printStackTrace();
    	}
	}
	
	public static void cont() {
		String label1 = "Would you like to get another pet?";
		int input = -1;
		
		input = puw.customButtonDialog(label1, null, null, false, "Yes", "No", "Cancel");
		
		if(input == 2 || input == 3) {
			cont = false;
			db.closeConnection();
    		System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		unitTesting();
		
		dbConnect();
		
		dataTasks();
		
		while (cont) {
			chooseAnimal();
			
			animalIntro();
			
			animalName();
			
			animalFavFood();
			
			animalSpeak();
			
			cont();
		}
		
	}
}
