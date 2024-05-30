package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class PreviousResults extends JFrame {

    PreviousResults() {
        setBounds(300, 100, 800, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Previous Results");
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading, BorderLayout.NORTH);

        String[] columnNames = {"Name", "Score"};
        Object[][] data = fetchData();

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private Object[][] fetchData() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object[][] data = {};

        try {
           
            String url = "jdbc:mysql://localhost:3306/quiz_db";
            String user = "root";
            String password = "Sanju@12";

            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT name, score FROM score";
            rs = stmt.executeQuery(sql);

            rs.last();
            int rowCount = rs.getRow();
            rs.beforeFirst();

            data = new Object[rowCount][2];
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("name");
                data[i][1] = rs.getInt("score");
                i++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) {
        new PreviousResults();
    }
}
