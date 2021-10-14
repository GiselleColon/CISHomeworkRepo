import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		//Test Runner
		Result result = JUnitCore.runClasses(MainTest.class);
		
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());
		//End Test Runner
		
//		include Cat
//
//		cat = new Cat()
//
//		println "Name is currently " + cat.name
//
//		cat.setName("Garfield")
//
//		println "Name has been changed to " + cat.name
//
//		data = new Data("database")
//
//		data.insert("Cat", cat);
	}

}
