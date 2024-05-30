package quiz.application;

import java.sql.*;

public class DisplayingQuestion {
  public static void main(String[] args) {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_db", "root", "Sanju@12");
      st = con.createStatement();
      // rs = st.executeQuery("SELECT * FROM questions");
      // while (rs.next()) {
      // System.out.println(rs.getString("question"));
      // System.out.println(rs.getString("option1"));
      // System.out.println(rs.getString("option2"));
      // System.out.println(rs.getString("option3"));
      // System.out.println(rs.getString("option4"));
      // System.out.println(rs.getString("correct_option"));
      // }
      rs = st.executeQuery("SELECT * FROM score");
      while (rs.next()) {
        System.out.println(rs.getString("name"));
        System.out.println(rs.getString("score"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        rs.close();
        st.close();
        con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }
}
