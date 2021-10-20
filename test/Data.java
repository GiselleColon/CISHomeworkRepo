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
			String url = "jdbc:sqlite:C:\\Users\\raine\\git\\CISHomeworkDBRepo\\CISHomeworkRepo\\db\\hwdb.db";
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			
			System.out.println("Connection to SQLite DB has been established.");
		} catch (SQLException ex) {
			System.out.println("CONNECT ERROR:");
			System.out.println(ex.getMessage());
		} /*finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException ex) {
				System.out.println("error:");
				System.out.println(ex.getMessage());
			}
		}*/
	}
	
	public void createTables() {
		String createInfoTable = "CREATE TABLE IF NOT EXISTS catInfo (id INTEGER PRIMARY KEY, "
				+ "age INTEGER, speak TEXT, favFood TEXT, alive BOOLEAN);";
		String createNameTable = "CREATE TABLE IF NOT EXISTS catNames (cat_id INTEGER, name TEXT);";
		
		try {
			stmt.execute(createInfoTable);
			stmt.execute(createNameTable);
			
			System.out.println("Tables have been created.");
		} catch(SQLException ex) {
			System.out.println("CREATE TABLES ERROR:");
			System.out.println(ex.getMessage());
		}
	}
	
	public void insert (String table, Cat cat) {	
		String tableName = "";
		String sql = "";
		
		if(table == "info") {
			tableName = "catInfo";
			sql = "INSERT INTO catInfo(age, speak, favFood, alive) VALUES(" +
					cat.getAge() + ",'" + cat.getSpeak() + "','" + cat.getFavFood() + "'," + cat.getAlive() + ")";
		} else if(table == "names") {
			tableName = "catNames";
			sql = "INSERT INTO catNames(cat_id, name) VALUES(" +
					getCatID() + ",'" + cat.getName() + "')";
			
			System.out.println("Inserting " + cat.getName() + " into table " + tableName);
		}
		
		try {
			stmt.execute(sql);
		} catch(SQLException ex) {
			System.out.println("INSERT ERROR:");
			System.out.println(ex.getMessage());
		}
    }
	
	public int getCatID() {
		String getID = "SELECT id FROM catInfo ORDER BY id DESC LIMIT 1";
		int id = 0;
		
		try {
			ResultSet rs = stmt.executeQuery(getID);
			
			id = rs.getInt("id");
		} catch(SQLException ex) {
			System.out.println("GET CAT ID ERROR:");
			System.out.println(ex.getMessage());
		}
		
		return id;
	}
	
	public String[] getCatNames() {
		String getNames = "SELECT name FROM catNames WHERE cat_id = " + getCatID();
		String getNamesLength = "SELECT COUNT(name) FROM catNames WHERE cat_id = " + getCatID();
		int namesLength = 0;
				
		try {
			ResultSet rs = stmt.executeQuery(getNamesLength);
			
			namesLength = rs.getInt(1);
		} catch(SQLException ex) {
			System.out.println("GET CAT ID ERROR:");
			System.out.println(ex.getMessage());
		}
		
		String[] names = new String[namesLength];
		int i = 0;
		
		try {
			ResultSet rs = stmt.executeQuery(getNames);
			
			while(rs.next()) {
				names[i] = rs.getString("name");
				i++;
			}
		} catch(SQLException ex) {
			System.out.println("GET CAT ID ERROR:");
			System.out.println(ex.getMessage());
		}
		
		return names;
	}
	
	public void update (String col, Cat cat) {
		String sql = "";
		String updateFavFood = "UPDATE catInfo SET favFood = '" + cat.getFavFood() + "' WHERE id = " + getCatID();
		String updateSpeak = "UPDATE catInfo SET speak = '" + cat.getSpeak() + "' WHERE id = " + getCatID();
		String updateAge = "UPDATE catInfo SET age = " + cat.getAge() + " WHERE id = " + getCatID();
		String updateDeath = "UPDATE catInfo SET alive = " + cat.getAlive() + " WHERE id = " + getCatID();
		
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
		} catch(SQLException ex) {
			System.out.println("UPDATE ERROR:");
			System.out.println(ex.getMessage());
		}
	}

//    method beginTran {
//        println "Beginning a transaction"
//        return db.begin
//    }
//
//    method commit {
//        println "Committing transaction"
//        return db.commit
//    }
//    
//    method rollback {
//        println "Rolling back transaction"
//        return db.rollback
//    }
}
