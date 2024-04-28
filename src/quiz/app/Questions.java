package quiz.app;

public class Questions {
    public static String[][] questions = new String[10][5];
    public static String[][] answers = new String[10][2];
    public static String[][] useranswers = new String[10][1];

    static {
        questions[0][0] = "Number of primitive data types in Java are.?";
        questions[0][1] = "6";
        questions[0][2] = "7";
        questions[0][3] = "8";
        questions[0][4] = "9";

        questions[1][0] = "What is the size of float and double in java.?";
        questions[1][1] = "32 and 64";
        questions[1][2] = "32 and 32";
        questions[1][3] = "64 and 64";
        questions[1][4] = "64 and 32";

        questions[2][0] = "Automatic type conversion is possible in which of the possible cases?";
        questions[2][1] = "Byte to int";
        questions[2][2] = "Int to Long";
        questions[2][3] = "Long to int";
        questions[2][4] = "Short to int";

        questions[3][0] = "When an array is passed to a method, what does the method receive?";
        questions[3][1] = "The reference of the array";
        questions[3][2] = "A copy of the array";
        questions[3][3] = "Length of the array";
        questions[3][4] = "Copy of first element";

        questions[4][0] = "Arrays in java are.?";
        questions[4][1] = "Object References";
        questions[4][2] = "Objects";
        questions[4][3] = "Primitive data type";
        questions[4][4] = "None";

        questions[5][0] = "When is the object created with new keyword?";
        questions[5][1] = "At rum time";
        questions[5][2] = "At compile time";
        questions[5][3] = "Depends on the code";
        questions[5][4] = "None";

        questions[6][0] = "Identify the corrected definition of a package.?";
        questions[6][1] = "A package is a collection of editing tools";
        questions[6][2] = "A package is a collection of Classes";
        questions[6][3] = "A package is a collection of Classes and interfaces";
        questions[6][4] = "A package is a collection of interfaces";

        questions[7][0] = "compareTo() returns";
        questions[7][1] = "True";
        questions[7][2] = "False";
        questions[7][3] = "An int value";
        questions[7][4] = "None";

        questions[8][0] = "To which of the following does the class string belong to.";
        questions[8][1] = "java.lang";
        questions[8][2] = "java.awt";
        questions[8][3] = "java.applet";
        questions[8][4] = "java.String";

        questions[9][0] = "Total constructor string class have.?";
        questions[9][1] = "3";
        questions[9][2] = "7";
        questions[9][3] = "13";
        questions[9][4] = "20";

        answers[0][1] = "8";
        answers[1][1] = "32 and 64";
        answers[2][1] = "Int to Long";
        answers[3][1] = "The reference of the array";
        answers[4][1] = "Objects";
        answers[5][1] = "At rum time";
        answers[6][1] = "A package is a collection of Classes and interfaces";
        answers[7][1] = "An int value";
        answers[8][1] = "java.lang";
        answers[9][1] = "13";
    }

    public static void main(String[] args) {

    }
}
