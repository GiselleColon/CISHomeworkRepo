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
	String name;
    int age;
    String speak;
    String favoriteFood;
    int times_spoke;
    
    public Cat() {
    	int max_age = 10;
    	int min_age = 5;

    	name = "";
    	age = (int) (Math.random()*(max_age - min_age + 1)) + min_age;
    	times_spoke = 0;
//        favoriteFood = nil
    }
//
//    method getName {
//        return name
//    }
//
//    method getAge {
//        return age
//    }
//    
//    method getFavoriteFood {
//        return FavoriteFood
//    }
//    
    public String setName (String newName) {
        name = newName;
        
        return name;
    }
    
    public String setRandName () {
    	int max = names.length;
    	int temp = (int) (Math.random()*max);
    	
    	name = names[temp];
    	
    	return name;
    }
//
//    method setAge (newAge) {
//        age = newAge
//    }
//    
//    method setFavoriteFood (newFavoriteFood) {
//        FavoriteFood = newFavoriteFood
//    }
    
    public void speak(String speaking) {
    	String meow = "";
    	
    	if(speaking != null) {
    		meow = speaking;
    	} else {
    		meow = "meow";
    	}
    	
    	speak = meow;
    	
    	System.out.println(meow);
    	times_spoke++;
    	
    	if(times_spoke == 5) {
    		age++;
    		System.out.println("Your cat just had a birthday! They're now " + age + " years old.");
    		times_spoke = 0;
    	}
    }
}
