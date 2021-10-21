public class DataTasks {
	
	public DataTasks(Data db) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		db.insert("info", cat, null);
		cat.setName("rand", db, cat);

		db.insert("info", null, dog);
		dog.setName("rand", db, dog);
	}
	
	public void savePetShop(Data db) {
		for(int i=0; i<3; i++) {
			Cat cat = new Cat();
			Dog dog = new Dog();
			
			db.insert("info", cat, null);
			db.insert("info", null, dog);
			
			cat.setName("rand", db, cat);
			dog.setName("rand", db, dog);
			
			cat.setFavFood("rand");
			dog.setFavFood("rand");
			db.update("favFood", cat, null);
			db.update("favFood", null, dog);
			
			cat.setSpeak("rand");
			dog.setSpeak("rand");
			db.update("speak", cat, null);
			db.update("speak", null, dog);
		}
	}
}
