package quiz.application;

import java.sql.*;

public class CreatingDatabase {
  public static void main(String[] args) {
    Connection con = null;
    Statement st = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Sanju@12");
      st = con.createStatement();
      st.executeUpdate("CREATE DATABASE quiz_db");
      st.executeUpdate("USE quiz_db");
      st.executeUpdate(
          "CREATE TABLE questions (id INT AUTO_INCREMENT PRIMARY KEY, question VARCHAR(255) NOT NULL, option1 VARCHAR(255) NOT NULL, option2 VARCHAR(255) NOT NULL, option3 VARCHAR(255) NOT NULL, option4 VARCHAR(255) NOT NULL, correct_option VARCHAR(255) NOT NULL)");
      System.out.println("Database created successfully");
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        st.close();
        con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
// CREATE DATABASE quiz_db;

// USE quiz_db;

// CREATE TABLE questions (
// id INT AUTO_INCREMENT PRIMARY KEY,
// question VARCHAR(255) NOT NULL,
// option1 VARCHAR(255) NOT NULL,
// option2 VARCHAR(255) NOT NULL,
// option3 VARCHAR(255) NOT NULL,
// option4 VARCHAR(255) NOT NULL,
// correct_option VARCHAR(255) NOT NULL
// );
