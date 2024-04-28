package database;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class CreateTable {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "fardin35";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS questions (" +
                    "que_id INT NOT NULL AUTO_INCREMENT," +
                    "que VARCHAR(255) NOT NULL," +
                    "opt1 VARCHAR(255) NOT NULL," +
                    "opt2 VARCHAR(255) NOT NULL," +
                    "opt3 VARCHAR(255) NOT NULL," +
                    "opt4 VARCHAR(255) NOT NULL," +
                    "ans INT NOT NULL," +
                    "PRIMARY KEY (que_id)" +
                    ");";
            boolean effect = statement.execute(sql);
            if (!effect) {
                System.out.println("Table creation successful..!");
            } else {
                System.out.println("Table creation unsuccessful..!");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
