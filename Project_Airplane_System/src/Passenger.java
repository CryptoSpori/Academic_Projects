import java.util.Scanner;

public class Passenger {

    private String passengerName;
    private String phoneNumber;
    private int age;
    private String gender;
    private int numberOfBags;
    private boolean carryOn;
    private double account;

    Passenger() {
        passengerName = "OPEN";
        this.phoneNumber = "0000000000";
        this.age = 0;
        this.gender = "Unknown";
        this.numberOfBags = 0;
        this.carryOn = false;
        this.account = 0;
    }

    void enterPassengerInformation(double someFee) {
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        System.out.println("ENTER PASSENGER INFORMATION:");
        System.out.println("Name: ");
        String name = keyboard.nextLine();
        setPassengerName(name);
        System.out.println("Phone Number: ");
        String phoneNumber = keyboard.nextLine();
        setPhoneNumber(phoneNumber);
        System.out.println("Age: ");
        int age = keyboard2.nextInt();
        setAge(age);
        System.out.println("Gender: ");
        String gender = keyboard.nextLine();
        setGender(gender);
        System.out.println("Enter Number of Bags: ");
        int numberOfBags = keyboard2.nextInt();
        setNumberOfBags(numberOfBags);
        System.out.println("Does passenger have Carry On Bags Enter (Y or N)");
        String carryOn = keyboard.nextLine();
        setCarryOn(carryOn);
        setAccount(someFee);
    }

    private void setPassengerName(String name) {
        passengerName = name;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setGender(String gender) {
        this.gender = gender;
    }

    private void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    private void setCarryOn(String carryOn) {
        if(carryOn.equalsIgnoreCase("y")) {
            this.carryOn = true;
        }
    }

    private void setAccount(double account) {
        this.account = account;
    }

    //Get Methods
    String getPassengerName() {
        return passengerName;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    int getAge() {
        return age;
    }

    String getGender() {
        return gender;
    }

    int getNumberOfBags() {
        return numberOfBags;
    }

    boolean isCarryOn() {
        return carryOn;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerName='" + passengerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", numberOfBags=" + numberOfBags +
                ", carryOn=" + carryOn +
                ", account=" + account +
                '}';
    }
}
