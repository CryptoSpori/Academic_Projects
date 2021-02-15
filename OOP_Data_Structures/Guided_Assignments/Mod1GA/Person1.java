package Mod1GA;

public class Person1
{
    //*** Task #1: define the instance variables
    private String name;
    private int idNumber;
    private String department;

    //*** Task #2: write the no-argument constructor that
    public Person1() {
        this.name = "";
        this.idNumber = 0;
        this.department = "";
    }

    //*** Task #3: write the constructor that passes values for the name and idNumber
    public Person1(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.department = "";
    }

    //*** Task #4: write the constructor that initializes all three instance variables
    public Person1(String name, int idNumber, String department){
        this.name = name;
        this.idNumber = idNumber;
        this.department = department;
    }

    //*** Task #5: write accessor method for attribute name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //*** Task #7: write accessor method for attribute idNumber
    public  int getIdNumber() {
        return idNumber;
    }

    //*** Task #8: write mutator method for attribute idNumber
    public void setIdName(int idNumber) {
        this.idNumber = idNumber;
    }

    //*** Task #9: write accessor method for attribute department
    public String getDepartment() {
        return department;
    }

    //*** Task #10: write mutator method for attribute department
    public void setDepartment(String department) {
        this.department = department;
    }

    //*** Task #11: write toString method
    @Override
    public String toString() {
        return " Name: " + name + " \n ID Number: " + idNumber + " \n Department: " + department + "\n";
    }
}