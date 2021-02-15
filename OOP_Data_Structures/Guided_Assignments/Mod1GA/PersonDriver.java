package Mod1GA;

public class PersonDriver
{
    public static void main(String[] args)
    {
        //*** Task #1: define and instantiate three objects of type Person, using the three constructors
        System.out.println("Initial Information about person \n");
        Person1 personOne = new Person1();
        Person1 personTwo = new Person1("Jane Young", 32421);
        Person1 personThree = new Person1("Ella Jones", 54231, "IT");

        //*** Task #2: display the information of the three objects of type Person
        System.out.println(personOne);
        System.out.println(personTwo);
        System.out.println(personThree);

        //*** Task #3
        personOne.setName("Jimmy Dean");
        personOne.setIdName(23123);
        personOne.setDepartment("Sales");
        personTwo.setDepartment("Marketing");

        //*** Task #4: display the updated information of the three persons
        System.out.println("New Information about person \n");
        System.out.println(personOne);
        System.out.println(personTwo);
        System.out.println(personThree);

    }
}