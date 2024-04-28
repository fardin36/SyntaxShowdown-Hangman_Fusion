package quiz.app;

import database.RetrieveData;

import java.sql.SQLException;

public class Questions {
    private String[][] questions = new String[15][6];
    private int[] answers = new int[10];
    private String[][] useranswers = new String[10][1];

    Questions(int numQue) throws SQLException {
        RetrieveData retrieveData = new RetrieveData(numQue);
    }
    public static void main(String[] args) {

    }
}
