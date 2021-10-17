import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Data {
	Connection conn = null;
	
	public void connect() {
		try {
			String url = "jdbc:sqlite:C:\\Users\\raine\\git\\CISHomeworkDBRepo\\CISHomeworkRepo\\db\\hwdb.db";
			conn = DriverManager.getConnection(url);
			
			System.out.println("Connection to SQLite DB has been established.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	public void createTables() {
		String createTable = "CREATE TABLE IF NOT EXISTS catInfo (id INTEGER PRIMARY KEY, "
				+ "name TEXT, age INTEGER, speak TEXT, favFood TEXT, alive BOOLEAN);";
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
//
//    method insert (table, object) {
//        println "Inserting " + object.getName() + " into table " + table
//        return db.insert
//    }
}
