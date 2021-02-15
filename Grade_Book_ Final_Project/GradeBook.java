import java.util.Scanner;
public class GradeBook {
    private int numberStudents;
    private GradeComponent[] classRoster;
    private double classAverage;

    //// CONSTRUCTOR
    public GradeBook() {
        setClassRoster();
    }

    ///// SET METHODS
    public void setClassRoster() {
        System.out.println("Enter Number of Students");
        Scanner keyboard = new Scanner(System.in);
        numberStudents = keyboard.nextInt();
        System.out.println("Enter Number of Assignments");
        int numberAssignments = keyboard.nextInt();
        System.out.println("Enter Number of Quiz");
        int numberQuiz = keyboard.nextInt();
        classRoster = new GradeComponent[numberStudents];
        for (int i = 0; i < numberStudents; i++) {
            String returnName = setStudentNames(i);
            classRoster[i] = new GradeComponent(numberAssignments, numberQuiz, returnName);
            classRoster[i].enterStudentData();
        }
    }
    public void setClassAverage() {
        double sum = 0;
        for (int i = 0; i < numberStudents; i++) {
            sum = sum + classRoster[i].getStudentFinalGrade();
        }
        sum = sum / numberStudents;
        classAverage = sum;
    }

    public String  setStudentNames(int index) {
        String tempName;
        tempName = "" + (index+1);
        return tempName;
    }
    public void setNumberGradeCount() {
        char tempChar;
        int aCount =0;
        int bCount =0;
        int cCount =0;
        int dCount =0;
        int fCount =0;
        char[] letterGrades =  new char[numberStudents];
        for (int i = 0; i < numberStudents; i++) {
            tempChar =  classRoster[i].getLetterGrade();
            letterGrades[i] = tempChar;
        }
        for (int i = 0; i < letterGrades.length; i++) {
            tempChar = letterGrades[i];
            if (tempChar == 'A')
            {
                aCount = aCount + 1;
            }
            else if (tempChar == 'B')
            {
                bCount = bCount + 1;
            }
            else if (tempChar == 'C')
            {
                cCount = cCount + 1;
            }
            else if (tempChar == 'D')
            {
                dCount = dCount + 1;
            }
            else if (tempChar == 'F')
            {
                fCount = fCount + 1;
            }
            else {
                System.out.println("Something went wrong");
            }
        }

        System.out.println("GRADE BREAK DOWN:");
        System.out.println("A: " + aCount);
        System.out.println("B: " + bCount);
        System.out.println("C: " + cCount);
        System.out.println("D: " + dCount);
        System.out.println("F: " + fCount);

    }
    public void checkForFinal(){
        int studentCount = 0;
        double sum = 0;
        for (int i = 0; i < numberStudents; i++) {
            sum = 0;
            sum = sum + classRoster[i].getStudentFinalGrade();
            sum = sum - 20;
            if (sum > 76.8) {
                studentCount = studentCount + 1;
            }
        }
        System.out.println("\nNumber of students with an A without final: " + studentCount );
    }
    ///// GET STRING
    public double getClassAverage() {
        return classAverage;
    }

    ///// TO STRING
    public String toString() {
        setClassAverage();
        double tempAverage = getClassAverage();
        System.out.println("\n\n\nCLASS GRADE REPORT");
        System.out.println("---------------------------------");
        System.out.println("CLASS AVG: " +tempAverage);
        String someString;

        setNumberGradeCount();
        someString = "\n";

        checkForFinal();

        return someString;
    }
}
