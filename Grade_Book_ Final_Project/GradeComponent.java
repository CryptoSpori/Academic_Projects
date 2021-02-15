import java.util.Scanner;

public class GradeComponent {
    private String studentName;
    private int NUM_ASSIGNMENTS;
    private int NUM_QUIZ;
    private double[] assignmentGrades;
    private double[] quizGrades;
    private double assignmentSum;
    private double quizSum;
    private double finalExamGrade;
    private double studentFinalGrade;
    private char letterGrade;
    /////CONSTRUCTOR
    public GradeComponent () {
    }
    public GradeComponent (int newNumAssignments, int newNumQuiz, String studentName) {
        NUM_ASSIGNMENTS =  newNumAssignments;
        NUM_QUIZ = newNumQuiz;
        this.studentName = studentName;
    }
    /////DATA ENTRY METHODS
    public void enterStudentData() {
        double grades;
        Scanner keyboard = new Scanner(System.in);
        setAssignmentGrades();
        setQuizGrades();
        System.out.println("Enter all Grades: " +NUM_ASSIGNMENTS+ " assignment, " + NUM_QUIZ+ " quiz, and 1 final exam for student " + studentName+ ".");
        for (int i = 0; i < NUM_ASSIGNMENTS; i++) {
            grades = keyboard.nextDouble();
            setAssignmentArray(i, grades);
        }
        for (int i = 0; i < NUM_QUIZ; i++) {
            grades = keyboard.nextDouble();
            setQuizArray(i, grades);
        }
        finalExamGrade = keyboard.nextDouble();
        setAssignmentSum();
        setQuizSum();
        setStudentFinalGrade();
        setLetterGrade(studentFinalGrade);
    }
    /////SET METHODS
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public void setNUM_ASSIGNMENTS(int newNumberAssignments) {
        NUM_ASSIGNMENTS = newNumberAssignments;
    }
    public void setNUM_QUIZ(int newNumberQuiz) {
        NUM_QUIZ = newNumberQuiz;
    }
    public void setAssignmentGrades() {
        assignmentGrades = new double[NUM_ASSIGNMENTS];
    }
    public void setQuizGrades() {
        quizGrades = new double[NUM_QUIZ];
    }
    public void setAssignmentSum() {
        assignmentSum = calculationSumMethod(NUM_ASSIGNMENTS, assignmentGrades);
    }
    public void setQuizSum() {
        quizSum = calculationSumMethod(NUM_QUIZ, quizGrades);
    }
    public void setAssignmentArray(int index, double someGrade) {
        assignmentGrades[index] = someGrade;
    }
    public void setQuizArray(int index, double someGrade) {
        quizGrades[index] = someGrade;
    }
    public void setStudentFinalGrade() {
        studentFinalGrade = assignmentSum + quizSum + finalExamGrade;
    }
    public void  setLetterGrade (double studentFinalGrade) {
        letterGrade = calculateLetterGrade(studentFinalGrade);
    }
    ///// GET METHODS
    public String getStudentName() {
        return studentName;
    }
    public double getStudentFinalGrade() {
        return studentFinalGrade;
    }
    public char getLetterGrade() {
        return letterGrade;
    }

    /////CALCULATION AND HELPER METHODS
    private double calculationSumMethod( int someCount, double[] someArrayOfNumbers) {
        double someSumOfNumber = 0.0;
        for (int i = 0; i < someCount; i++) {
            someSumOfNumber = someSumOfNumber + someArrayOfNumbers[i];
        }
        return someSumOfNumber;
    }
    private double calculationAvgMethod( int someCount, double someNumbers) {
        double avgOfNumber;
        avgOfNumber = someNumbers / someCount;
        return avgOfNumber;
    }
    private double calculationSDMethod( int someCount, double[] someArrayOfNumbers) {
        double tempSum = calculationSumMethod(someCount, someArrayOfNumbers);
        double tempAvg = calculationAvgMethod(someCount, tempSum);
        double sum_sq_dev = 0.0;
        double someStandardDeviation = 0;
        for (int i=0; i<someCount; i++) {
            sum_sq_dev = sum_sq_dev + (Math.pow(someArrayOfNumbers[i] - tempAvg, 2));
            someStandardDeviation = Math.sqrt(sum_sq_dev / someCount);
        }
        return someStandardDeviation;
    }

    private char calculateLetterGrade(double someGrade) {
        char someLetter = '?';
        if (someGrade > 89)
            someLetter = 'A';
        else if (someGrade > 79)
            someLetter = 'B';
        else if (someGrade > 74)
            someLetter = 'C';
        else if (someGrade > 69)
            someLetter = 'C';
        else if (someGrade <= 69)
            someLetter = 'F';
        return someLetter;
    }
    ///// TO STRING METHODS
    public String toString() {
        String someString;
        someString = "";
        someString = someString + "\n";
        //someString = someString + "\nSTUDENT: " + getStudentName();
        someString = someString + "\nASSIGNMENT GRADES:\n";
        for (int i =0; i < NUM_ASSIGNMENTS; i++)  {
            someString = someString + assignmentGrades[i] + " ";
        }
        someString = someString + "\nQUIZ GRADES:\n";
        for (int i =0; i < NUM_QUIZ; i++)  {
            someString = someString + quizGrades[i] + " ";
        }
        someString = someString + "\nFINAL EXAM GRADE: " + finalExamGrade;
        setAssignmentSum();
        double assignmentAvg = calculationAvgMethod(NUM_ASSIGNMENTS, assignmentSum);
        double assignmentSD =  calculationSDMethod(NUM_ASSIGNMENTS, assignmentGrades);
        someString = someString + "\nASSIGNMENT SUM: " + assignmentSum;
        someString = someString + "\nASSIGNMENT AVG: " + assignmentAvg;
        someString = someString + "\nASSIGNMENT SD: " + assignmentSD;
        setQuizSum();
        double quizAvg = calculationAvgMethod(NUM_QUIZ, quizSum);
        double quizSD =  calculationSDMethod(NUM_QUIZ, quizGrades);
        someString = someString + "\nQUIZ SUM: " + quizSum;
        someString = someString + "\nQUIZ AVG: " + quizAvg;
        someString = someString + "\nQUIZ SD: " + quizSD;
        double finalGradeSum = getStudentFinalGrade();
        someString = someString + "\nFINAL GRADE: " + finalGradeSum;
        char letterGrade = getLetterGrade();
        someString = someString + "\nYou have an " + letterGrade + " in this class!";
        return someString;
    }
}
