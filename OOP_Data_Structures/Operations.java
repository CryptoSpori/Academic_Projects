package Mod6_Project_2;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Operations {

    protected LineList lines;

    Operations() {
        lines = new LineList();
    }

    public void showHeader() {
        String header = "";
        header = header + "_____________________________________________________________________________________\n";
        header = header + "CLI LINE EDITOR (LEI) INTERFACE Version 1\n";
        header = header + "=====================================================================================\n";
        header = header + "[LEI]--> Hello human, type m to view menu options if needed.";
        System.out.println(header);
    }

    public void showMenu() {
        System.out.println("_____________________________________________________________________________________");
        System.out.println("[LEI MENU COMMANDS...]");
        System.out.println("Menu: m");
        System.out.println("Load File: load fileName appendOption (1-append, 0-new list)");
        System.out.println("Print: p");
        System.out.println("Display number of lines: lines");
        System.out.println("Display line: lineNumber");
        System.out.println("Count words: words");
        System.out.println("Delete line: del lineNumberToDelete");
        System.out.println("Append line: a");
        System.out.println("Insert line: i lineNumberToInsert");
        System.out.println("Clear document: cls");
        System.out.println("Replace words: rep originalWord newWord");
        System.out.println("Save to a file: s fileName");
        System.out.println("Quit: quit");
        System.out.println("[...LEI MENU COMMANDS]");
        System.out.println("_____________________________________________________________________________________\n\n");
    }

    public void loadFileByName() throws FileNotFoundException {
        Scanner stringKeyboard = new Scanner(System.in);
        Scanner intKeyboard = new Scanner(System.in);
        System.out.print("[ENTER FILENAME]: ");
        String fileName = stringKeyboard.next();
        System.out.print("[ENTER APPEND OPTION (1-append 0-new list)]: ");
        int appendOption = intKeyboard.nextInt();
        String loadFile = "src\\Mod6_Project_2\\" + fileName + ".txt";
        lines.load(loadFile, appendOption == 1);
    }

    public void saveFileByName() throws IOException {
        Scanner stringKeyboard = new Scanner(System.in);
        System.out.print("[ENTER FILENAME]: ");
        String fileName = stringKeyboard.next();
        lines.save("src\\Mod6_Project_2\\" + fileName + ".txt");
        System.out.println("[FILE SAVED]!");
    }

    public void addLine() {
        Scanner stringKeyboard = new Scanner(System.in);
        System.out.print("[ENTER LINE TEXT]: ");
        String lineText = stringKeyboard.nextLine();
        lines.addLine(lineText);
    }

    public void insertLine() {
        Scanner stringKeyboard = new Scanner(System.in);
        Scanner intKeyboard = new Scanner(System.in);
        System.out.print("[ENTER LINE TEXT]: ");
        String lineText = stringKeyboard.nextLine();
        System.out.print("[ENTER LINE NUMBER]: ");
        int lineNumber = intKeyboard.nextInt();
        lines.addLine(lineText, lineNumber);
    }

    public void delete() {
        Scanner intKeyboard = new Scanner(System.in);
        System.out.print("[ENTER LINE NUMBER TO DELETE]: ");
        int lineNumber = intKeyboard.nextInt();
        lines.delete(lineNumber);
        System.out.println("[DELETED] ");
    }

    public void clear(){
        lines.empty();
        System.out.println("[LINES CLEARED] ");
    }

    public void numberOffLines(){
        System.out.println("[NUMBER OF LINES]: " + lines.lines());
        lines.lines();
    }

    public void numberOfWords(){
        System.out.println("[NUMBER OF WORDS]: " + lines.words());
    }

    public void replaceWords(){
        Scanner stringKeyboard = new Scanner(System.in);
        System.out.print("ENTER TARGET WORD: ");
        String s1 = stringKeyboard.next();
        System.out.print("ENTER NEW WORD: ");
        String s2 = stringKeyboard.next();
        lines.replace(s1, s2);
        System.out.println("[DONE!]");
    }

    public void print(){
        System.out.println("\n_____________________________________________________________________________________");
        lines.print();
        System.out.println("_____________________________________________________________________________________\n");
    }
}
