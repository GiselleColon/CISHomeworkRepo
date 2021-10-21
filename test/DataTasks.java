public class DataTasks {
	
	public DataTasks(Data db) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		cat.start(db, cat);
		cat.setName("rand", db, cat);

		dog.start(db, dog);
		dog.setName("rand", db, dog);
	}
	
	public void savePetShop(Data db) {
		for(int i=0; i<3; i++) {
			Cat cat = new Cat();
			Dog dog = new Dog();
			
			cat.start(db, cat);
			dog.start(db, dog);
			
			cat.setName("rand", db, cat);
			dog.setName("rand", db, dog);
			
			cat.setFavFood("rand");
			cat.update(db, cat, "favFood");
			dog.setFavFood("rand");
			dog.update(db, dog, "favFood");
			
			cat.setSpeak("rand");
			cat.update(db, cat, "speak");
			dog.setSpeak("rand");
			dog.update(db, dog, "speak");
		}
	}
}
