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
//        favoriteFood = nil
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
    
//    method getFavoriteFood {
//        return FavoriteFood
//    }
//    
    public void setName (String newName) {
        name = newName;
    }
    
    public void setRandName () {
    	int max = names.length;
    	int temp = (int) (Math.random() * max);
    	
    	name = names[temp];
    }

    public void setAge (int newAge) {
        age = newAge;
    }
//    
//    method setFavoriteFood (newFavoriteFood) {
//        FavoriteFood = newFavoriteFood
//    }
    
    public void speak(String speaking) {
    	String meow = "";
    	int max = diff_speak.length;
    	int temp = (int) (Math.random() * max);
    	int currAge = getAge();
    	
    	if(speaking == "rand") {
    		meow = diff_speak[temp];
    	} else if(speaking != null) {
    		meow = speaking;
    	} else {
    		meow = "meow";
    	}
    	
    	speak = meow;
    	
    	System.out.println(meow);
    	times_spoke++;
    	
    	if(times_spoke == 5) {
    		currAge++;
    		setAge(currAge);
    		System.out.println(getName() + " just had a birthday! They're now " + getAge() + " years old.");
    		times_spoke = 0;
    	}
    }
}
