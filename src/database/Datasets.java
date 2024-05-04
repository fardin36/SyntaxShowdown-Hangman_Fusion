package database;

public class Datasets {
    public static String[][] javaQuestions = {
            // Question 1
            {
                    "What is the result of 5 + 3 * 2?",
                    "A) 10",
                    "B) 11",
                    "C) 13",
                    "D) 16",
                    "2"
            },
            // Question 2
            {
                    "Which keyword is used to define a constant in Java?",
                    "A) final",
                    "B) const",
                    "C) static",
                    "D) let",
                    "1"
            },
            // Question 3
            {
                    "Which of the following is NOT a primitive data type in Java?",
                    "A) int",
                    "B) float",
                    "C) string",
                    "D) boolean",
                    "3"
            },
            // Question 4
            {
                    "What is the superclass of all classes in Java?",
                    "A) Object",
                    "B) Super",
                    "C) Base",
                    "D) Parent",
                    "1"
            },
            // Question 5
            {
                    "What is the output of the following code?\nint x = 10; System.out.println(x > 5 ? \"Yes\" : \"No\");",
                    "A) Yes",
                    "B) No",
                    "C) Compilation error",
                    "D) Runtime error",
                    "1"
            },
            // Question 6
            {
                    "What is the result of the following code?\nint x = 5; int y = x++ + ++x;",
                    "A) 10",
                    "B) 11",
                    "C) 12",
                    "D) 13",
                    "3"
            },
            // Question 7
            {
                    "Which of the following is true about Java interfaces?",
                    "A) Interfaces can contain instance variables.",
                    "B) A class can implement multiple interfaces with conflicting methods.",
                    "C) Interfaces can be instantiated.",
                    "D) Interfaces can contain constructors.",
                    "2"
            },
            // Question 8
            {
                    "What is the output of the following code?\nString str1 = \"hello\", str2 = new String(\"hello\");\nSystem.out.println(str1 == str2);",
                    "A) true",
                    "B) false",
                    "C) Compilation error",
                    "D) Runtime error",
                    "2"
            },
            // Question 9
            {
                    "Which of the following is NOT a Java keyword?",
                    "A) class",
                    "B) struct",
                    "C) interface",
                    "D) extends",
                    "2"
            },
            // Question 10
            {
                    "What is the output of the following code?\nint[] arr = {1, 2, 3}; System.out.println(arr);",
                    "A) 1 2 3",
                    "B) [1, 2, 3]",
                    "C) Memory address of arr",
                    "D) Compilation error",
                    "3"
            },
            // Question 11
            {
                    "What does the 'static' keyword mean in Java?",
                    "A) A variable or method belongs to the class, rather than instances of the class.",
                    "B) A variable or method can only be accessed within the same package.",
                    "C) A variable or method is accessible from anywhere in the program.",
                    "D) A variable or method cannot be overridden.",
                    "1"
            },
            // Question 12
            {
                    "What is the purpose of the 'final' keyword in Java?",
                    "A) It indicates that a variable cannot be changed after initialization.",
                    "B) It indicates that a class cannot be extended.",
                    "C) It indicates that a method cannot be overridden.",
                    "D) All of the above.",
                    "4"
            },
            // Question 13
            {
                    "Which collection class allows you to associate a unique key with each value?",
                    "A) ArrayList",
                    "B) LinkedList",
                    "C) HashMap",
                    "D) TreeSet",
                    "3"
            },
            // Question 14
            {
                    "What is the output of the following code?\nint x = 10; System.out.println(x < 5 ? \"Yes\" : \"No\");",
                    "A) Yes",
                    "B) No",
                    "C) Compilation error",
                    "D) Runtime error",
                    "2"
            },
            // Question 15
            {
                    "What is the output of the following code?\nString str = null; System.out.println(str.length());",
                    "A) null",
                    "B) 0",
                    "C) Compilation error",
                    "D) Runtime error",
                    "4"
            },
            // Question 16
            {
                    "What is the result of the following code?\nint x = 7, y = 2;\nSystem.out.println(x / y);",
                    "A) 3.5",
                    "B) 3",
                    "C) 3.0",
                    "D) Compilation error",
                    "2"
            },
            // Question 17
            {
                    "Which of the following is true about constructors in Java?",
                    "A) Constructors can have return types.",
                    "B) Constructors can be overloaded.",
                    "C) Constructors can be inherited.",
                    "D) Constructors can be declared as private.",
                    "2"
            },
            // Question 18
            {
                    "What is the output of the following code?\nint[][] arr = {{1, 2}, {3, 4, 5}};\nSystem.out.println(arr.length);",
                    "A) 2",
                    "B) 3",
                    "C) Compilation error",
                    "D) Runtime error",
                    "2"
            },
            // Question 19
            {
                    "Which of the following statements is true about Java garbage collection?",
                    "A) It guarantees that a program will not run out of memory.",
                    "B) It can be explicitly invoked by the programmer.",
                    "C) It is performed by deallocating memory that is no longer in use.",
                    "D) It can only be performed manually.",
                    "3"
            },
            // Question 20
            {
                    "What is the output of the following code?\nString str = \"Java\"; str.concat(\" is fun!\");\nSystem.out.println(str);",
                    "A) Java",
                    "B) Java is fun!",
                    "C) Compilation error",
                    "D) Runtime error",
                    "1"
            },
            // Question 21
            {
                    "What is the output of the following code?\nint x = 10; System.out.println(x++ + ++x);",
                    "A) 20",
                    "B) 21",
                    "C) 22",
                    "D) Compilation error",
                    "3"
            },
            // Question 22
            {
                    "What is the purpose of the 'this' keyword in Java?",
                    "A) It refers to the superclass of the current class.",
                    "B) It refers to the current instance of the class.",
                    "C) It creates an instance of a class.",
                    "D) It refers to the subclass of the current class.",
                    "2"
            },
            // Question 23
            {
                    "What is the output of the following code?\nString str = \"Hello\"; str.toLowerCase();\nSystem.out.println(str);",
                    "A) Hello",
                    "B) hello",
                    "C) Compilation error",
                    "D) Runtime error",
                    "1"
            },
            // Question 24
            {
                    "Which of the following is NOT a valid identifier in Java?",
                    "A) myVariable",
                    "B) _myVariable",
                    "C) 1stVariable",
                    "D) $myVariable",
                    "3"
            },
            // Question 25
            {
                    "What is the output of the following code?\nint[][] arr = {{1, 2, 3}, {4, 5}, {6}};\nSystem.out.println(arr[1].length);",
                    "A) 1",
                    "B) 2",
                    "C) 3",
                    "D) Compilation error",
                    "2"
            },
            // Question 26
            {
                    "What is the result of the following code?\nint x = 10;\nint y = x-- + --x;",
                    "A) 19",
                    "B) 20",
                    "C) nothing",
                    "D) 22",
                    "3"
            },
            // Question 27
            {
                    "What is the purpose of the 'super' keyword in Java?",
                    "A) It is used to call the superclass constructor.",
                    "B) It is used to access the superclass members from subclass.",
                    "C) It is used to invoke a superclass method.",
                    "D) All of the above.",
                    "4"
            },
            // Question 28
            {
                    "What is the output of the following code?\nString str = \"Java\"; str.toUpperCase();\nSystem.out.println(str);",
                    "A) Java",
                    "B) JAVA",
                    "C) Compilation error",
                    "D) Runtime error",
                    "1"
            },
            // Question 29
            {
                    "Which of the following is a valid declaration of a char array?",
                    "A) char[] charArray = new char[];",
                    "B) char[] charArray = new char[10];",
                    "C) char charArray[10];",
                    "D) All of the above.",
                    "2"
            },
            // Question 30
            {
                    "What is the output of the following code?\nString[][] arr = { {\"a\", \"b\", \"c\"}, {\"d\", \"e\", \"f\"} };\nSystem.out.println(arr[1][1]);",
                    "A) a",
                    "B) b",
                    "C) e",
                    "D) f",
                    "3"
            },
            // Question 31
//            {
//                    "Which of the following statements about Java packages is true?",
//                    "A) Packages cannot contain sub-packages.",
//                    "B) A package can be imported in its entirety or only specific classes or interfaces from within the package can be imported.",
//                    "C) All classes and interfaces within a package must have the same access modifier.",
//                    "D) Packages are mainly used for organizing files on disk.",
//                    "B) A package can be imported in its entirety or only specific classes or interfaces from within the package can be imported."
//            },
            // Question 32
            {
                    "What is the result of the following code?\nint x = 3, y = 6; int z = x < y ? x++ : y++;\nSystem.out.println(z);",
                    "A) 7",
                    "B) 6",
                    "C) 4",
                    "D) 3",
                    "4"
            },
            // Question 33
            {
                    "What is the purpose of the 'break' statement in Java?",
                    "A) to exit a loop or switch statement.",
                    "B) to skip the current iteration of a loop.",
                    "C) to terminate the program.",
                    "D) to jump to a specific label in the code.",
                    "1"
            },
            // Question 34
            {
                    "Which of the following is not a valid Java identifier?",
                    "A) _myVariable",
                    "B) $myVariable",
                    "C) 123variable",
                    "D) my_Variable",
                    "3"
            },
            // Question 35
            {
                    "What is the output of the following code?\nint x = 5; System.out.println(x / 0);",
                    "A) 0",
                    "B) Compilation error",
                    "C) Runtime error",
                    "D) Infinity",
                    "3"
            }
    };

    public static void main(String[] args) {

    }
}
