public class Cat {
	Data db = new Data();
	
	String[] names = {
		"Mustafa",
		"Tom",
		"Figaro",
		"Crookshanks",
		"Felix",
		"Chesshire",
		"Mrs. Norris",
		"Simba",
		"Nala",
		"Mews"
	};
	String[] diff_speak = {
		"nya",
		"mau",
		"miaow",
		"miau",
		"meong",
		"mew",
		"meo"
	};
	String[] food = {
		"tuna",
		"chicken",
		"salmon",
		"plastic",
		"beef"
	};
	String name;
    int age;
    int deathAge;
    boolean alive;
    String speak;
    String favoriteFood;
    int times_spoke;
    
    public Cat() {
    	int max_age = 10;
    	int min_age = 5;
    	int startAge = (int) (Math.random()*(max_age - min_age + 1)) + min_age;

    	setName("");
    	setAge(startAge);
    	setDeathAge();
    	times_spoke = 0;
    }

    public String getName() {
        return name;
    }
    
//    public String[] getNames() {
//    	return db.getCatNames();
//    }

    public int getAge() {
        return age;
    }
    
    public int getDeathAge() {
    	return deathAge;
    }
    
    public boolean getAlive() {
    	return alive;
    }
    
    public String getSpeak() {
    	return speak;
    }
    
    public String getFavFood() {
        return favoriteFood;
    }
    
    public void setAll(String type, String input, int temp) {
    	if(input == "rand") {
    		if(type == "name") {
    			name = names[temp];
    		} else if(type == "food") {
    			favoriteFood = food[temp];
    		} else if(type == "speak") {
    			speak = diff_speak[temp];
    		}
    	} else if(input != null) {
    		if(type == "name") {
    			name = input;
    		} else if(type == "food") {
    			favoriteFood = input;
    		} else if(type == "speak") {
    			speak = input;
    		}
    	} else {
    		if(type == "food") {
    			favoriteFood = "cat food";
    		} else if(type == "speak") {
    			speak = "meow";
    		}
    	}
    }
    
    public void setName (String newName) {
    	int max = names.length;
    	int temp = (int) (Math.random() * max);
    	
    	setAll("name", newName, temp);
    }

    public void setAge (int newAge) {
        age = newAge;
    }
    
    public void setDeathAge () {
    	int max = 20;
    	int min = 15;
    	int death = (int) (Math.random()*(max - min + 1)) + min;
    	
    	deathAge = death;
    	alive = true;
    }
    
    public void setFavFood (String newFavoriteFood) {
    	int max = food.length;
    	int temp = (int) (Math.random() * max);
    	
    	setAll("food", newFavoriteFood, temp);
    }
    
    public void speak(String speaking) {
    	int max = diff_speak.length;
    	int temp = (int) (Math.random() * max);
    	int currAge = getAge();
    	
    	setAll("speak", speaking, temp);
    	
    	System.out.println(getSpeak());
    	times_spoke++;
    	
    	if(times_spoke == 5) {
    		currAge++;
    		setAge(currAge);
    		
    		if(getAge() == getDeathAge()) {
    			System.out.println("I'm so sorry but " + getName() + " has passed away from old age at " + getAge() + " years old.");
    			alive = false;
    		} else {
    			System.out.println(getName() + " just had a birthday! They're now " + getAge() + " years old.");
    		}
    		
    		times_spoke = 0;
    	}
    }
}
