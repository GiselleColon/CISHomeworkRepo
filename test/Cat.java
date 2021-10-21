public class Cat {
	PopUpWindows puw = new PopUpWindows();
	
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

    	setName("", null, null);
    	setAge(startAge);
    	setDeathAge();
    	times_spoke = 0;
    }
    
    public void reset() {
    	int max_age = 10;
    	int min_age = 5;
    	int startAge = (int) (Math.random()*(max_age - min_age + 1)) + min_age;

    	setName("", null, null);
    	setAge(startAge);
    	setDeathAge();
    	times_spoke = 0;
    }
    
    public void start(Data db, Cat cat) {
    	db.insert("info", cat, null);
    }
    
    public void update(Data db, Cat cat, String type) {
    	if(type == "favFood") {
    		db.update("favFood", cat, null);
    	} else if(type == "speak") {
    		db.update("speak", cat, null);
    	} else if(type == "age") {
    		db.update("age", cat, null);
    	} else if(type == "death") {
    		db.update("death", cat, null);
    	}
    }

    public String getName() {
        return name;
    }
    
    public String[] getNames(Data db) {
    	return db.getNames("cat");
    }

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
    
    public void setName (String newName, Data db, Cat cat) {
    	int max = names.length;
    	int temp = (int) (Math.random() * max);
    	
    	setAll("name", newName, temp);
    	
    	if(db != null) {
    		db.insert("names", cat, null);
    	}
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
    
    public void setSpeak(String speaking) {
    	int max = diff_speak.length;
    	int temp = (int) (Math.random() * max);
    	
    	setAll("speak", speaking, temp);
    }
    
    public void speak(String speaking) {
    	int currAge = getAge();
    	
    	setSpeak(speaking);
    	
    	System.out.println(getSpeak());
    	times_spoke++;
    	
    	if(times_spoke == 5) {
    		currAge++;
    		setAge(currAge);
    		String output = "";
    		
    		if(getAge() == getDeathAge()) {
    			output = "I'm so sorry but " + getName() + " has passed away from old age at " + getAge() + " years old.";
    			puw.showDialog(output);
    			alive = false;
    		} else {
    			output = getName() + " just had a birthday! They're now " + getAge() + " years old.";
    			puw.showDialog(output);
    		}
    		
    		times_spoke = 0;
    	}
    }
}
