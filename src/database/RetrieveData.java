package database;

import java.sql.*;
import java.util.Arrays;

public class RetrieveData {
    private final String url = "jdbc:mysql://localhost:3306/mydb";
    private final String username = "root";
    private final String password = "fardin35";
    String[][] questions = new String[15][5];
    int[] answers = new int[10];

    public RetrieveData(int numQuestions) {

        // Question 1
        questions[0][0] = "What is the primary purpose of the `public` keyword in Java?";
        questions[0][1] = "To hide a member variable or method";
        questions[0][2] = "To make a member variable or method accessible from anywhere";
        questions[0][3] = "To create a loop";
        questions[0][4] = "To handle user input";
        answers[0] = 2; // Correct answer: Option 2

// Question 2
        questions[1][0] = "What is the correct syntax to declare a primitive integer variable in Java?";
        questions[1][1] = "int num = 0;";
        questions[1][2] = "Integer num = new Integer(0);";
        questions[1][3] = "String num = '0';";
        questions[1][4] = "float num = 0.0;";
        answers[1] = 1; // Correct answer: Option 1

// Question 3
        questions[2][0] = "What is the difference between a `while` loop and a `for` loop in Java?";
        questions[2][1] = "There's no difference, they both do the same thing.";
        questions[2][2] = "`while` loop checks the condition before each iteration, `for` loop updates a counter each iteration.";
        questions[2][3] = "`while` loop is used for infinite loops, `for` loop is for finite loops.";
        questions[2][4] = "`while` loop is for user input, `for` loop is for iterating over collections.";
        answers[2] = 2; // Correct answer: Option 2

// Question 4
        questions[3][0] = "What is the output of the following code: `System.out.println(\"Hello\" + 5);`";
        questions[3][1] = "5Hello";
        questions[3][2] = "Hello5";
        questions[3][3] = "Compilation error";
        questions[3][4] = "An infinite loop";
        answers[3] = 2; // Correct answer: Option 2 (Java performs string concatenation before printing)

// Question 5
        questions[4][0] = "What is the purpose of a `main` method in a Java class?";
        questions[4][1] = "To define a constructor for the class";
        questions[4][2] = "To define the entry point of a program";
        questions[4][3] = "To store global variables";
        questions[4][4] = "To handle exceptions";
        answers[4] = 2; // Correct answer: Option 2

// Question 6
        questions[5][0] = "What is the difference between an interface and an abstract class in Java?";
        questions[5][1] = "There's no difference, they both do the same thing.";
        questions[5][2] = "An interface defines what a class can do, an abstract class defines how something is done.";
        questions[5][3] = "An interface can have methods, an abstract class cannot.";
        questions[5][4] = "Interfaces can be inherited, abstract classes cannot.";
        answers[5] = 2; // Correct answer: Option 2

// Question 7
        questions[6][0] = "What is the keyword used to inherit from a class in Java?";
        questions[6][1] = "include";
        questions[6][2] = "extend";
        questions[6][3] = "implement";
        questions[6][4] = "use";
        answers[6] = 2; // Correct answer: Option 2

// Question 8
        questions[7][0] = "What is the difference between a primitive data type and an object in Java?";
        questions[7][1] = "There's no difference.";
        questions[7][2] = "Primitive data types are basic data types like int and String, objects are instances of classes.";
        questions[7][3] = "Primitive data types are stored on the heap, objects are stored on the stack.";
        questions[7][4] = "Primitive data types can be null, objects cannot.";
        answers[7] = 2; // Correct answer: Option 2

// Question 8
        questions[8][0] = "What is the difference between a primitive data type and an object in Java?";
        questions[8][1] = "There's no difference.";
        questions[8][2] = "Primitive data types are basic data types like int and String, objects are instances of classes.";
        questions[8][3] = "Primitive data types are stored on the heap, objects are stored on the stack.";
        questions[8][4] = "Primitive data types can be null, objects cannot.";
        answers[8] = 2; // Correct answer: Option 2

// Question 8
        questions[9][0] = "What is the difference between a primitive data type and an object in Java?";
        questions[9][1] = "There's no difference.";
        questions[9][2] = "Primitive data types are basic data types like int and String, objects are instances of classes.";
        questions[9][3] = "Primitive data types are stored on the heap, objects are stored on the stack.";
        questions[9][4] = "Primitive data types can be null, objects cannot.";
        answers[9] = 2; // Correct answer: Option 2


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
