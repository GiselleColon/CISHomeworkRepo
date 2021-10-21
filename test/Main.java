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
		System.out.println("\nAre you looking for a cat or a dog?");
		
		animal = sc.nextLine();
		
		if(!animal.equalsIgnoreCase("cat") && !animal.equalsIgnoreCase("dog")) {
			System.out.println("It looks like you didn't enter cat or dog.");
			System.out.println("Program is now terminating.");
			
			db.closeConnection();
			System.exit(0);
		}
	}
	
	public static void animalIntro() {
		System.out.println("\nMeet your new "+ animal.toLowerCase() + "!");
		
		if(animal.equalsIgnoreCase("cat")) {
			System.out.println("They are " + cat.getAge() + " years old.");
			System.out.println("Name is currently " + cat.getName());
			db.insert("info", cat, null);
			cat.setName("Garfield");
			System.out.println("Name has been changed to " + cat.getName() + ".");
			db.insert("names", cat, null);
		} else if(animal.equalsIgnoreCase("dog")) {
			System.out.println("They are " + dog.getAge() + " years old.");
			System.out.println("Name is currently " + dog.getName());
			db.insert("info", null, dog);
			dog.setName("Spot");
			System.out.println("Name has been changed to " + dog.getName() + ".");
			db.insert("names", null, dog);
		}
	}
	
	public static void animalName() {
		String input_name = "";
		
		System.out.println("\nYou can enter your own name now.");
		System.out.println("Alternatively we can randomly pick one for you, just say random.");
		System.out.println("If you'd like to keep it the same, just say no.");
		
		input_name = sc.nextLine();
		
		if(input_name.equalsIgnoreCase("random")) {
			if(animal.equalsIgnoreCase("cat")) {
				cat.setName("rand");
				System.out.println("Your cat's new name is " + cat.getName() + ".");
			} else if(animal.equalsIgnoreCase("dog")) {
				dog.setName("rand");
				System.out.println("Your dog's new name is " + dog.getName() + ".");
			}
		} else if(input_name.equalsIgnoreCase("no")) {
			if(animal.equalsIgnoreCase("cat")) {
				System.out.println("Okay we'll keep the same name, " + cat.getName() + ".");
			} else if(animal.equalsIgnoreCase("dog")) {
				System.out.println("Okay we'll keep the same name, " + dog.getName() + ".");
			}
		} else {
			if(animal.equalsIgnoreCase("cat")) {
				cat.setName(input_name);
				System.out.println("You have changed your cat's name to " + cat.getName() + ".");
			} else if(animal.equalsIgnoreCase("dog")) {
				dog.setName(input_name);
				System.out.println("You have changed your dog's name to " + dog.getName() + ".");
			}
		}
		
		String[] names = null;
		
		if(animal.equalsIgnoreCase("cat")) {
			db.insert("names", cat, null);
			names = db.getNames("cat");
		} else if(animal.equalsIgnoreCase("dog")) {
			db.insert("names", null, dog);
			names = db.getNames("dog");
		}
		
		System.out.println("\nHere are all the names your " + animal.toLowerCase() + " has had so far:");
		
		for(int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
		
		System.out.println("The average length of the names is " + db.getAverageNameLength(animal.toLowerCase()) + ".");
	}
	
	public static void animalFavFood() {
		String input_food = "";
		
		if(animal.equalsIgnoreCase("cat")) {
			System.out.println("\nWhat would you like " + cat.getName() + "'s favorite food to be?");
		} else if(animal.equalsIgnoreCase("dog")) {
			System.out.println("\nWhat would you like " + dog.getName() + "'s favorite food to be?");
		}
		
		System.out.println("You can let us pick a favorite food for you, just say random");
		System.out.println("If you'd like just some generic cat food, just say no");
		
		input_food = sc.nextLine();
		
		if(input_food.equalsIgnoreCase("random")) {
			if(animal.equalsIgnoreCase("cat")) {
				cat.setFavFood("rand");
				System.out.println(cat.getName() + "'s new favorite food is " + cat.getFavFood() + ".");
			} else if(animal.equalsIgnoreCase("dog")) {
				dog.setFavFood("rand");
				System.out.println(dog.getName() + "'s new favorite food is " + dog.getFavFood() + ".");
			}
		} else if(input_food.equalsIgnoreCase("no")) {
			if(animal.equalsIgnoreCase("cat")) {
				cat.setFavFood(null);
				System.out.println("Okay " + cat.getName() + " will just enjoy " + cat.getFavFood() + ".");
			} else if(animal.equalsIgnoreCase("dog")) {
				dog.setFavFood(null);
				System.out.println("Okay " + dog.getName() + " will just enjoy " + dog.getFavFood() + ".");
			}
		} else {
			if(animal.equalsIgnoreCase("cat")) {
				cat.setFavFood(input_food);
				System.out.println(cat.getName() + "'s favorite food is " + cat.getFavFood() + ".");
			} else if(animal.equalsIgnoreCase("dog")) {
				dog.setFavFood(input_food);
				System.out.println(dog.getName() + "'s favorite food is " + dog.getFavFood() + ".");
			}
		}
		
		if(animal.equalsIgnoreCase("cat")) {
			db.update("favFood", cat, null);
		} else if(animal.equalsIgnoreCase("dog")) {
			db.update("favFood", null, dog);
		}
	}
	
	public static void animalSpeak() {
		String input_speak = "";
		
		if(animal.equalsIgnoreCase("cat")) {
			System.out.println("\nDoes your cat, " + cat.getName() + ", go nya, mau, or something else?");
			System.out.println("You can let us pick a meow for you cat, just say random.");
			System.out.println("If you'd like generic meowing, just say no.");
		} else if(animal.equalsIgnoreCase("dog")) {
			System.out.println("\nDoes your dog, " + dog.getName() + ", go wuff, bow, or something else?");
			System.out.println("You can let us pick a bark for you dog, just say random.");
			System.out.println("If you'd like generic barking, just say no.");
		}
		
		input_speak = sc.nextLine();
		
		if(input_speak.equalsIgnoreCase("random")) {
			if(animal.equalsIgnoreCase("cat")) {
				cat.speak("rand");
				System.out.println("Your cat now goes " + cat.getSpeak() + ".");
			} else if(animal.equalsIgnoreCase("dog")) {
				dog.speak("rand");
				System.out.println("Your dog now goes " + dog.getSpeak() + ".");
			}
		} else if(input_speak.equalsIgnoreCase("no")) {
			if(animal.equalsIgnoreCase("cat")) {
				System.out.println("Okay we'll give " + cat.getName() + " the generic meow.");
				cat.speak(null);
			} else if(animal.equalsIgnoreCase("dog")) {
				System.out.println("Okay we'll give " + dog.getName() + " the generic bark.");
				dog.speak(null);
			}
		} else {
			if(animal.equalsIgnoreCase("cat")) {
				System.out.println("You have decided to have " + cat.getName() + " go " + input_speak + ".");
				cat.speak(input_speak);
			} else if(animal.equalsIgnoreCase("dog")) {
				System.out.println("You have decided to have " + dog.getName() + " go " + input_speak + ".");
				dog.speak(input_speak);
			}
		}
		
		if(animal.equalsIgnoreCase("cat")) {
			db.update("speak", cat, null);
		} else if(animal.equalsIgnoreCase("dog")) {
			db.update("speak", null, dog);
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
	    				db.update("age", cat, null);
	    				currAge = cat.getAge();
	    			}
	    		}
	    		
	    		if(!cat.alive) {
	    			db.update("death", cat, null);
	    			db.closeConnection();
	    			System.exit(0);
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
	    				db.update("age", null, dog);
	    				currAge = dog.getAge();
	    			}
	    		}
	    		
	    		if(!dog.alive) {
	    			db.update("death", null, dog);
	    			db.closeConnection();
	    			System.exit(0);
	    		}
			}
    	} catch(InterruptedException ex) {
    		ex.printStackTrace();
    	}
	}
	
	public static void main(String[] args) {
		unitTesting();
		
		dbConnect();
		
		dataTasks();
		
		chooseAnimal();
		
		animalIntro();
		
		animalName();
		
		animalFavFood();
		
		animalSpeak();
	}
}
