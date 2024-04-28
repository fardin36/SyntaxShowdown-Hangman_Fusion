package database;

import java.sql.*;

public class RetrieveData {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "fardin35";

    public static void main(String[] args) {
        int numQuestions = 15; // Number of random questions to retrieve

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // Create a statement object
            Statement statement = conn.createStatement();

            // SQL statement to retrieve random questions
            String sql = "SELECT * FROM questions ORDER BY RAND() LIMIT " + numQuestions;

            // Execute the statement and get the result set
            ResultSet resultSet = statement.executeQuery(sql);

            // Process the result set
            int count = 0;
            if (resultSet.next()) {
                while (resultSet.next() && count < numQuestions) {
                    // Display the retrieved question and options
                    System.out.println("Question " + (count + 1) + ":");
                    System.out.println(resultSet.getString("que"));
                    System.out.println("  a) " + resultSet.getInt("opt1"));
                    System.out.println("  b) " + resultSet.getString("opt2"));
                    System.out.println("  c) " + resultSet.getString("opt3"));
                    System.out.println("  d) " + resultSet.getString("opt4"));
                    System.out.println("  Ans: " + resultSet.getInt("ans"));
                    count++;
                }
            } else {
                System.out.println("No questions found!");
            }

            // Close resources
            resultSet.close();
            statement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error retrieving questions: " + e.getMessage());
        }
    }
}
