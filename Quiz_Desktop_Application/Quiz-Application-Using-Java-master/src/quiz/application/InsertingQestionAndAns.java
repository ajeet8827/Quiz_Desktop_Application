package quiz.application;

// "CREATE TABLE questions (id INT AUTO_INCREMENT PRIMARY KEY, question VARCHAR(255) NOT NULL, option1 VARCHAR(255) NOT NULL, option2 VARCHAR(255) NOT NULL, option3 VARCHAR(255) NOT NULL, option4 VARCHAR(255) NOT NULL, correct_option VARCHAR(255) NOT NULL)");
import java.sql.*;

public class InsertingQestionAndAns {
  public static void main(String[] args) {
    Connection con = null;
    Statement st = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_db", "root", "Sanju@12");
      st = con.createStatement();
      st.executeUpdate(
          "INSERT INTO questions (question, option1, option2, option3, option4, correct_option) VALUES ('What is the capital of India?', 'Mumbai', 'Delhi', 'Kolkata', 'Chennai', 'Delhi')");
      st.executeUpdate(
          "INSERT INTO questions (question, option1, option2, option3, option4, correct_option) VALUES ('What is the capital of Australia?', 'Sydney', 'Melbourne', 'Canberra', 'Perth', 'Canberra')");
      st.executeUpdate(
          "INSERT INTO questions (question, option1, option2, option3, option4, correct_option) VALUES ('What is the capital of USA?', 'New York', 'Washington D.C.', 'Los Angeles', 'Chicago', 'Washington D.C.')");
      st.executeUpdate(
          "INSERT INTO questions (question, option1, option2, option3, option4, correct_option) VALUES ('What is the capital of UK?', 'Manchester', 'Birmingham', 'London', 'Liverpool', 'London')");
      st.executeUpdate(
          "INSERT INTO questions (question, option1, option2, option3, option4, correct_option) VALUES ('What is the capital of Japan?', 'Tokyo', 'Osaka', 'Kyoto', 'Hiroshima', 'Tokyo')");
      st.executeUpdate(
          "INSERT INTO questions (question, option1, option2, option3, option4, correct_option) VALUES ('What is the capital of China?', 'Shanghai', 'Beijing', 'Hong Kong', 'Shenzhen', 'Beijing')");
      st.executeUpdate(
          "INSERT INTO questions (question, option1, option2, option3, option4, correct_option) VALUES ('What is the capital of Russia?', 'Moscow', 'St. Petersburg', 'Vladivostok', 'Novosibirsk', 'Moscow')");
      st.executeUpdate(
          "INSERT INTO questions (question, option1, option2, option3, option4, correct_option) VALUES ('What is the capital of Brazil?', 'Sao Paulo', 'Rio de Janeiro', 'Brasilia', 'Salvador', 'Brasilia')");
      st.executeUpdate(
          "INSERT INTO questions (question, option1, option2, option3, option4, correct_option) VALUES ('What is the capital of Canada?', 'Toronto', 'Vancouver', 'Montreal', 'Ottawa', 'Ottawa')");
      st.executeUpdate(
          "INSERT INTO questions (question, option1, option2, option3, option4, correct_option) VALUES ('What is the capital of South Africa?', 'Johannesburg', 'Cape Town', 'Durban', 'Pretoria', 'Pretoria')");
      System.out.println("Questions inserted successfully");
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
