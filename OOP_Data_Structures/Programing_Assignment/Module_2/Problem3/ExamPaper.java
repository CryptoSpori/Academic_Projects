package Mod2PA.Problem3;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 10/10/2020
 *
 * ExamPaper.java
 */
public class ExamPaper {

    private String studentName;
    private int examScore;

    //Constructors
    public ExamPaper() {
        this.studentName = "No Name";
        this.examScore = 0;
    }
    public ExamPaper(String studentName, int examScore) {
        this.studentName = studentName;
        this.examScore = examScore;
    }

    //Getter and setter methods
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getExamScore() {
        return examScore;
    }
    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }

    //TO STRING Method
    public String toString() {
        return "Student: " + studentName + " Score: " + examScore;
    }
}
