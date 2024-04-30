package database;

import java.sql.*;
import java.util.Arrays;

public class RetrieveData {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "fardin35";
    //    String[][] questions = new String[15][5];
    String[][] questions = new String[][]{{
            "What is the primary purpose of the `public` keyword in Java?", "To hide a member variable or method", "To make a member variable or method accessible from anywhere", "To create a loop", "To handle user input"}, {
            "What is the correct syntax to declare a primitive integer variable in Java?", "int num = 0;", "Integer num = new Integer(0);", "String num = '0';", "float num = 0.0;"}, {
            "What is the difference between a `while` loop and a `for` loop in Java? What is the difference between a `while` loop and a `for` loop in Java? What is the difference between a `while` loop and a `for` loop in Java?", "There's no difference, they both do the same thing.", "`while` loop checks the condition before each iteration, `for` loop updates a counter each iteration.", "`while` loop is used for infinite loops, `for` loop is for finite loops.", "`while` loop is for user input, `for` loop is for iterating over collections."}, {
            "What is the output of the following code: `System.out.println(\"Hello\" + 5);`", "5Hello", "Hello5", "Compilation error", "An infinite loop"}, {
            "What is the purpose of a `main` method in a Java class?", "To define a constructor for the class", "To define the entry point of a program", "To store global variables", "To handle exceptions"}, {
            "What is the difference between an interface and an abstract class in Java?", "There's no difference, they both do the same thing.", "An interface defines what a class can do, an abstract class defines how something is done.", "An interface can have methods, an abstract class cannot.", "Interfaces can be inherited, abstract classes cannot."}, {
            "What is the keyword used to inherit from a class in Java?", "include", "extend", "implement", "use"}, {
            "What is the difference between a primitive data type and an object in Java?", "There's no difference.", "Primitive data types are basic data types like int and String, objects are instances of classes.", "Primitive data types are stored on the heap, objects are stored on the stack.", "Primitive data types can be null, objects cannot."}, {
            "What is the difference between a primitive data type and an object in Java?", "There's no difference.", "Primitive data types are basic data types like int and String, objects are instances of classes.", "Primitive data types are stored on the heap, objects are stored on the stack.", "Primitive data types can be null, objects cannot."}, {
            "What is the difference between a primitive data type and an object in Java?", "There's no difference.", "Primitive data types are basic data types like int and String, objects are instances of classes.", "Primitive data types are stored on the heap, objects are stored on the stack.", "Primitive data types can be null, objects cannot."}, {
            "What is the difference between an interface and an abstract class in Java?", "There's no difference, they both do the same thing.", "An interface defines what a class can do, an abstract class defines how something is done.", "An interface can have methods, an abstract class cannot.", "Interfaces can be inherited, abstract classes cannot."}, {
            "What is the keyword used to inherit from a class in Java?", "include", "extend", "implement", "use"}, {
            "What is the difference between a primitive data type and an object in Java?", "There's no difference.", "Primitive data types are basic data types like int and String, objects are instances of classes.", "Primitive data types are stored on the heap, objects are stored on the stack.", "Primitive data types can be null, objects cannot."}, {
            "What is the difference between a primitive data type and an object in Java?", "There's no difference.", "Primitive data types are basic data types like int and String, objects are instances of classes.", "Primitive data types are stored on the heap, objects are stored on the stack.", "Primitive data types can be null, objects cannot."}, {
            "What is the difference between a primitive data type and an object in Java?", "There's no difference.", "Primitive data types are basic data types like int and String, objects are instances of classes.", "Primitive data types are stored on the heap, objects are stored on the stack.", "Primitive data types can be null, objects cannot."}
    };
    int[] answers = new int[]{2,1,2,2,2,2,2,2,2,2,2,2,2,2,2};

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
