package database;

import java.sql.*;
import java.util.Scanner;
import database.Datasets;

public class InsertData {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "fardin35";
    private static final String[][] javaQuestions = Datasets.javaQuestions;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Scanner scanner = new Scanner(System.in);
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO questions(que, opt1, opt2, opt3, opt4, ans) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            while (true) {
//                System.out.print("Enter question: ");
//                String que = scanner.nextLine();
//                System.out.print("Enter opt1: ");
//                String opt1 = scanner.nextLine();
//                System.out.print("Enter opt2: ");
//                String opt2 = scanner.nextLine();
//                System.out.print("Enter opt3: ");
//                String opt3 = scanner.nextLine();
//                System.out.print("Enter opt4: ");
//                String opt4 = scanner.nextLine();
//                System.out.print("Enter ans: ");
//                int ans = scanner.nextInt();
//                preparedStatement.setString(1, que);
//                preparedStatement.setString(2, opt1);
//                preparedStatement.setString(3, opt2);
//                preparedStatement.setString(4, opt3);
//                preparedStatement.setString(5, opt4);
//                preparedStatement.setInt(6, ans);
//                preparedStatement.addBatch();
//                System.out.print("More entries?(Y/N): ");
//                char i = scanner.next().charAt(0);
//                scanner.nextLine();
//                if (i == 'N' || i == 'n') {
//                    break;
//                }
//            }
            for (String[] javaQuestion : javaQuestions) {
                preparedStatement.setString(1, javaQuestion[0]);
                preparedStatement.setString(2, javaQuestion[1]);
                preparedStatement.setString(3, javaQuestion[2]);
                preparedStatement.setString(4, javaQuestion[3]);
                preparedStatement.setString(5, javaQuestion[4]);
                preparedStatement.setInt(6, Integer.parseInt(javaQuestion[5]));
                preparedStatement.addBatch();
            }
            int[] effects = preparedStatement.executeBatch();

            for (int i = 0; i < effects.length; i++) {
                if (effects[i] == 0) {
                    System.out.println("Insertion - " + i + " failed;");
                } else {
                    System.out.println("Insertion - " + i + " passed;");
                }
            }
            preparedStatement.close();
            connection.close();
            scanner.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}