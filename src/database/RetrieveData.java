package database;

import java.sql.*;
import java.util.Arrays;

public class RetrieveData {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "fardin35";
    //    String[][] questions = new String[15][5];
    String[][] questions = new String[][]{// Question 1
            {"What is the result of 5 + 3 * 2?", "A) 10", "B) 11", "C) 13", "D) 16"},
            // Question 2
            {"Which keyword is used to define a constant in Java?", "A) final", "B) const", "C) static", "D) let"},
            // Question 3
            {"Which of the following is NOT a primitive data type in Java?", "A) int", "B) float", "C) string", "D) boolean"},
            // Question 4
            {"What is the superclass of all classes in Java?", "A) Object", "B) Super", "C) Base", "D) Parent"},
            // Question 5
            {"What is the output of the following code?\nint x = 10; System.out.println(x > 5 ? \"Yes\" : \"No\");", "A) Yes", "B) No", "C) Compilation error", "D) Runtime error"},
            // Question 6
            {"What is the result of the following code?\nint x = 5; int y = x++ + ++x;", "A) 10", "B) 11", "C) 12", "D) 13"},
            // Question 7
            {"Which of the following is true about Java interfaces?", "A) Interfaces can contain instance variables.", "B) A class can implement multiple interfaces with conflicting methods.", "C) Interfaces can be instantiated.", "D) Interfaces can contain constructors."},
            // Question 8
            {"What is the output of the following code?\nString str1 = \"hello\", str2 = new String(\"hello\");\nSystem.out.println(str1 == str2);", "A) true", "B) false", "C) Compilation error", "D) Runtime error"},
            // Question 9
            {"Which of the following is NOT a Java keyword?", "A) class", "B) struct", "C) interface", "D) extends"},
            // Question 10
            {"What is the output of the following code?\nint[] arr = {1, 2, 3}; System.out.println(arr);", "A) 1 2 3", "B) [1, 2, 3]", "C) Memory address of arr", "D) Compilation error"},
            // Question 11
            {"What does the 'static' keyword mean in Java?", "A) A variable or method belongs to the class, rather than instances of the class.", "B) A variable or method can only be accessed within the same package.", "C) A variable or method is accessible from anywhere in the program.", "D) A variable or method cannot be overridden."},
            // Question 12
            {"What is the purpose of the 'final' keyword in Java?", "A) It indicates that a variable cannot be changed after initialization.", "B) It indicates that a class cannot be extended.", "C) It indicates that a method cannot be overridden.", "D) All of the above."},
            // Question 13
            {"Which collection class allows you to associate a unique key with each value?", "A) ArrayList", "B) LinkedList", "C) HashMap", "D) TreeSet"},
            // Question 14
            {"What is the output of the following code?\nint x = 10; System.out.println(x < 5 ? \"Yes\" : \"No\");", "A) Yes", "B) No", "C) Compilation error", "D) Runtime error"},
            // Question 15
            {"What is the output of the following code?\nString str = null; System.out.println(str.length());", "A) null", "B) 0", "C) Compilation error", "D) Runtime error"}};
    int[] answers = new int[]{2, 1, 3, 1, 1, 3, 2, 2, 2, 3, 1, 4, 3, 2, 4};

    public RetrieveData(int numQuestions) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            // Create a statement object
            Statement statement = connection.createStatement();
            // SQL statement to retrieve random questions
            String sql = "SELECT * FROM questions ORDER BY RAND() LIMIT " + numQuestions;
            // Execute the statement and get the result set
            ResultSet resultSet = statement.executeQuery(sql);
            try {
                int count = 0;
                while (resultSet.next()) {
                    questions[count][0] = resultSet.getString("que");
                    questions[count][1] = resultSet.getString("opt1");
                    questions[count][2] = resultSet.getString("opt2");
                    questions[count][3] = resultSet.getString("opt3");
                    questions[count][4] = resultSet.getString("opt4");
                    answers[count] = resultSet.getInt("ans");
                    count++;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
//            System.out.println("Error retrieving questions: " + e.getMessage());
        }
    }

    public String[][] getQuestions() {
        return questions;
    }

    public int[] getAnswers() {
        return answers;
    }

    private void printData() {
        System.out.println(Arrays.deepToString(questions));
    }

    public static void main(String[] args) {
        new RetrieveData(5);
    }
}
