package Mod2PA.Problem3;
/**
 * professor EMILIA BUTU
 * since   CS-202 (FALL 2020)
 *
 * @author Student name:  John C Stelly
 * Completion date: 10/10/2020
 *
 * ExamPaperOrganizer .java
 */

import java.util.Scanner;

public class ExamPaperOrganizer {

    public static void main(String[] args) {

        //Initialize Paper Stacks
        ExamPaperStack<ExamPaper> exams = new ExamPaperStack<>();
        ExamPaperStack<ExamPaper> aboveAvg = new ExamPaperStack<>();
        ExamPaperStack<ExamPaper> belowAvg = new ExamPaperStack<>();

        //Set Scanner for keyboard input
        Scanner enterNumber = new Scanner(System.in);
        Scanner enterString = new Scanner(System.in);

        // DO WHILE lOOP for Student and Grade input
        boolean addExam = true;
        do {
            System.out.print("Enter the name of the student or type end, if you are done: ");
            String studentName = enterString.nextLine();

            if (studentName.equalsIgnoreCase("end"))
                addExam = false;
            else {
                System.out.print("Enter exam score: ");
                int examScore =enterNumber.nextInt();
                exams.push(new ExamPaper(studentName, examScore));
            }
        } while (addExam);

        // Calculate sum and average scores from exam stack
        double sum = 0;
        LLNode<ExamPaper> tempPapers = exams.top;
        while (tempPapers != null) {
            sum = sum + tempPapers.getData().getExamScore();
            tempPapers = tempPapers.getLink();
        }
        //Calculate average score
        double avgScore = sum / exams.size();

        //Output Average score, students and exam score from exam stack
        System.out.println(exams);
        System.out.println("Number of exams graded: " + exams.size());
        System.out.println("Avarge score for the exam is: " + avgScore);

        //Sort grades in to specific stacks below or above average
        while (exams.top != null) {
            if (exams.top.getData().getExamScore() > avgScore) {
                ExamPaper temp = exams.poptop();
                aboveAvg.push(temp);
            }
            else if (exams.top.getData().getExamScore() < avgScore) {
                ExamPaper temp = exams.poptop();
                belowAvg.push(temp);
            }
        }

        //Output results of sorting by above average and below average
        System.out.println("\nExam that have above average scores:");
        System.out.println(aboveAvg);
        System.out.println("There are " + aboveAvg.size()+ " papers with scores under average\n");
        System.out.println("Exam that have below average scores:");
        System.out.println(belowAvg);
        System.out.println("There are " + belowAvg.size()+ " papers with scores under average");
    }
}
