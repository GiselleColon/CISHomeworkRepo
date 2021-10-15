public class Cat {
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
    String speak;
    String favoriteFood;
    int times_spoke;
    
    public Cat() {
    	int max_age = 10;
    	int min_age = 5;
    	int startAge = (int) (Math.random()*(max_age - min_age + 1)) + min_age;

    	setName("");
    	setAge(startAge);
    	times_spoke = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public String getSpeak() {
    	return speak;
    }
    
    public String getFavFood() {
        return favoriteFood;
    }
    
    public void setName (String newName) {
    	int max = names.length;
    	int temp = (int) (Math.random() * max);
    	
    	if(newName == "rand") {
    		name = names[temp];
    	} else if(newName != null) {
    		name = newName;
    	}
    }

    public void setAge (int newAge) {
        age = newAge;
    }
    
    public void setFavFood (String newFavoriteFood) {
    	int max = food.length;
    	int temp = (int) (Math.random() * max);
    	
    	if(newFavoriteFood == "rand") {
    		favoriteFood = food[temp];
    	} else if(newFavoriteFood != null) {
    		favoriteFood = newFavoriteFood;
    	} else {
    		favoriteFood = "cat food";
    	}
    }
    
    public void speak(String speaking) {
    	int max = diff_speak.length;
    	int temp = (int) (Math.random() * max);
    	int currAge = getAge();
    	
    	if(speaking == "rand") {
    		speak = diff_speak[temp];
    	} else if(speaking != null) {
    		speak = speaking;
    	} else {
    		speak = "meow";
    	}
    	
    	System.out.println(speak);
    	times_spoke++;
    	
    	if(times_spoke == 5) {
    		currAge++;
    		setAge(currAge);
    		System.out.println(getName() + " just had a birthday! They're now " + getAge() + " years old.");
    		times_spoke = 0;
    	}
    }
}
