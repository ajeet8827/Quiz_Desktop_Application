package quiz.application;
import java.sql.*;
public class ScoreTable {
  public static void main(String[] args) {
    Connection con = null;
    Statement st = null;
    try {
      // Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Sanju@12");
      st = con.createStatement();
      // st.executeUpdate("CREATE DATABASE quiz_db");
      st.executeUpdate("USE quiz_db");
      st.executeUpdate("CREATE TABLE score (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), score INT)");
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
// CREATE TABLE score (
//     id INT PRIMARY KEY AUTO_INCREMENT,
//     name VARCHAR(255),
//     score INT
// );
