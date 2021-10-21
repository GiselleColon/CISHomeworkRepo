import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Data {
	Connection conn = null;
	Statement stmt = null;
	
	public void connect() {
		try {
			System.out.println("Beginning a transaction.");
			String url = "jdbc:sqlite:C:\\Users\\raine\\git\\CISHomeworkDBRepo\\CISHomeworkRepo\\db\\hwdb.db";
			conn = DriverManager.getConnection(url);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			
			System.out.println("Connection to SQLite DB has been established.");
		} catch (SQLException ex) {
			System.out.println("CONNECT ERROR:");
			System.out.println(ex.getMessage());
		}
	}
	
	public void commitTran() {
		System.out.println("Committing transaction.");
		try {
			conn.commit();
		} catch(SQLException ex) {
			System.out.println("COMMIT TRAN ERROR:");
			System.out.println(ex.getMessage());
		}
	}
	
	public void rollbackTran() {
		System.out.println("Rolling back transaction.");
		try {
			conn.rollback();
		} catch(SQLException ex) {
			System.out.println("ROLLBACK TRAN ERROR:");
			System.out.println(ex.getMessage());
		}
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch(SQLException ex) {
			System.out.println("CLOSE CONNECTION ERROR:");
			System.out.println(ex.getMessage());
		}
	}
	
	public void createTables() {
		String createInfoTable = "CREATE TABLE IF NOT EXISTS animalInfo (id INTEGER PRIMARY KEY, "
				+ "animal TEXT, age INTEGER, speak TEXT, favFood TEXT, alive BOOLEAN);";
		String createCatNameTable = "CREATE TABLE IF NOT EXISTS catNames (cat_id INTEGER, name TEXT);";
		String createDogNameTable = "CREATE TABLE IF NOT EXISTS dogNames (dog_id INTEGER, name TEXT);";
		
		try {
			stmt.execute(createInfoTable);
			stmt.execute(createCatNameTable);
			stmt.execute(createDogNameTable);
			
			System.out.println("Tables have been created.");
		} catch(SQLException ex) {
			System.out.println("CREATE TABLES ERROR:");
			System.out.println(ex.getMessage());
		}
	}
	
	public void insert (String table, Cat cat, Dog dog) {	
		String tableName = "";
		String sql = "";
		
		if(table == "info") {
			tableName = "animalInfo";
			if(cat != null) {
				sql = "INSERT INTO animalInfo(animal, age, speak, favFood, alive) VALUES('cat'," +
						cat.getAge() + ",'" + cat.getSpeak() + "','" + cat.getFavFood() + "'," + cat.getAlive() + ")";
			} else if(dog != null) {
				sql = "INSERT INTO animalInfo(animal, age, speak, favFood, alive) VALUES('dog'," +
						dog.getAge() + ",'" + dog.getSpeak() + "','" + dog.getFavFood() + "'," + dog.getAlive() + ")";
			}
		} else if(table == "names") {
			if(cat != null) {
				tableName = "catNames";
				sql = "INSERT INTO catNames(cat_id, name) VALUES(" +
						getID("cat") + ",'" + cat.getName() + "')";
				
				System.out.println("Inserting " + cat.getName() + " into table " + tableName);
			} else if(dog != null) {
				tableName = "dogNames";
				sql = "INSERT INTO dogNames(dog_id, name) VALUES(" +
						getID("dog") + ",'" + dog.getName() + "')";
				
				System.out.println("Inserting " + dog.getName() + " into table " + tableName);
			}
		}
		
		try {
			stmt.execute(sql);
			commitTran();
		} catch(SQLException ex) {
			rollbackTran();
			System.out.println("INSERT ERROR:");
			System.out.println(ex.getMessage());
		}
    }
	
	public int getID(String animal) {
		String getID = "SELECT id FROM animalInfo WHERE animal = '" + animal.toLowerCase() + "' ORDER BY id DESC LIMIT 1";
		int id = 0;
		
		try {
			ResultSet rs = stmt.executeQuery(getID);
			
			id = rs.getInt("id");
		} catch(SQLException ex) {
			System.out.println("GET ID ERROR:");
			System.out.println(ex.getMessage());
		}
		
		return id;
	}
	
	public int getNumNames(String animal) {
		int numNames = 0;
		String getCatNamesLength = "SELECT COUNT(name) FROM catNames WHERE cat_id = " + getID(animal);
		String getDogNamesLength = "SELECT COUNT(name) FROM dogNames WHERE dog_id = " + getID(animal);
		
		try {
			if(animal.equalsIgnoreCase("cat")) {
				ResultSet rs = stmt.executeQuery(getCatNamesLength);
				
				numNames = rs.getInt(1);
			} else if(animal.equalsIgnoreCase("dog")) {
				ResultSet rs = stmt.executeQuery(getDogNamesLength);
				
				numNames = rs.getInt(1);
			}
		} catch(SQLException ex) {
			System.out.println("GET CAT ID ERROR:");
			System.out.println(ex.getMessage());
		}
		
		return numNames;
	}
	
	public String[] getNames(String animal) {
		String getCatNames = "SELECT name FROM catNames WHERE cat_id = " + getID(animal);
		String getDogNames = "SELECT name FROM dogNames WHERE dog_id = " + getID(animal);
		int namesLength = getNumNames(animal);
		
		String[] names = new String[namesLength];
		int i = 0;
		
		try {
			if(animal.equalsIgnoreCase("cat")) {
				ResultSet rs = stmt.executeQuery(getCatNames);
				
				while(rs.next()) {
					names[i] = rs.getString("name");
					i++;
				}
			} else if(animal.equalsIgnoreCase("dog")) {
				ResultSet rs = stmt.executeQuery(getDogNames);
				
				while(rs.next()) {
					names[i] = rs.getString("name");
					i++;
				}
			}
		} catch(SQLException ex) {
			System.out.println("GET CAT ID ERROR:");
			System.out.println(ex.getMessage());
		}
		
		return names;
	}
	
	public double getAverageNameLength(String animal) {
		double avgLength = 0;
		int numNames = getNumNames(animal);
		double value = 0;
		
		String[] names = getNames(animal);
		int[] namesLength = new int[numNames];
		
		for(int i=0; i<names.length; i++) {
			namesLength[i] = names[i].length();
		}
		
		for(int i=0; i<namesLength.length; i++) {
			value += Double.valueOf(namesLength[i]);
		}
		
		avgLength = value/numNames;
		
		return avgLength;
	}
	
	public void update (String col, Cat cat, Dog dog) {
		String sql = "", updateFavFood = "", updateSpeak = "", updateAge = "", updateDeath = "", animal = "";
		
		if(cat != null) {
			animal = "cat";
			updateFavFood = "UPDATE animalInfo SET favFood = '" + cat.getFavFood() + "' WHERE id = " + getID(animal);
			updateSpeak = "UPDATE animalInfo SET speak = '" + cat.getSpeak() + "' WHERE id = " + getID(animal);
			updateAge = "UPDATE animalInfo SET age = " + cat.getAge() + " WHERE id = " + getID(animal);
			updateDeath = "UPDATE animalInfo SET alive = " + cat.getAlive() + " WHERE id = " + getID(animal);
		} else if(dog != null) {
			animal = "dog";
			updateFavFood = "UPDATE animalInfo SET favFood = '" + dog.getFavFood() + "' WHERE id = " + getID(animal);
			updateSpeak = "UPDATE animalInfo SET speak = '" + dog.getSpeak() + "' WHERE id = " + getID(animal);
			updateAge = "UPDATE animalInfo SET age = " + dog.getAge() + " WHERE id = " + getID(animal);
			updateDeath = "UPDATE animalInfo SET alive = " + dog.getAlive() + " WHERE id = " + getID(animal);
		}
		
		if(col == "favFood") {
			sql =  updateFavFood;
		} else if (col == "speak") {
			sql = updateSpeak;
		} else if(col == "age") {
			sql = updateAge;
		} else if (col == "death") {
			sql = updateDeath;
		}
		
		try {
			stmt.execute(sql);
			commitTran();
		} catch(SQLException ex) {
			rollbackTran();
			System.out.println("UPDATE ERROR:");
			System.out.println(ex.getMessage());
		}
	}
}
