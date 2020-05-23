import java.util.Arrays;
import java.util.Scanner;
public class Airplane {
    private int airplaneNumber;
    private String manufacturerName;
    private String modelName;
    private String tailNumber;
    private int seatingCapacity;
    private  static int planNumber = 100;
    private double maxAirSpeed;
    private boolean[] seatsAvailable;
    private Passenger[] passengerSeats;
    private String destinationCode;
    private boolean planeStatus;


    public Airplane() {
        this.airplaneNumber = 0;
        this.manufacturerName = "Bombardier";
        this.modelName = "Global 750000";
        this.tailNumber = "DX-7520" + planNumber;
        this.seatingCapacity = 20;
        this.maxAirSpeed = 982;
        this.seatsAvailable = new boolean[seatingCapacity];
        this.passengerSeats = new Passenger[seatingCapacity];
        this.destinationCode = "NONE";
        this.planeStatus = true;
        planNumber++;
    }
    public void loadAirPlane(double someFee) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Passenger Seat Number");
        int someSeatNumber = keyboard.nextInt();
        if (getSeatStatus(someSeatNumber)) {
            System.out.println("NOTICE: Please Check Seat Status, Seat " +someSeatNumber+ " " +
                    "for this flight is already reserved!");
        }
        else {
            Passenger tempPassenger = new Passenger();
            tempPassenger.enterPassengerInformation(someFee);
            passengerSeats[someSeatNumber] = tempPassenger;
            setSeatsAvailable(someSeatNumber);
        }

    }
    public boolean getSeatStatus(int someSeatNumber) {
        boolean seatStatus;
        seatStatus = seatsAvailable[someSeatNumber];
        return seatStatus;
    }
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public void setMaxAirSpeed(double maxAirSpeed) {
        this.maxAirSpeed = maxAirSpeed;
    }

    public void setSeatsAvailable(boolean[] seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setSeatsAvailable(int someSeatNumber) {
        this.seatsAvailable[someSeatNumber] = true;
    }

    public void setPassengerSeats(Passenger[] passengerSeats) {
        this.passengerSeats = passengerSeats;
    }

    public void setAirplaneNumber(int airplaneNumber) {
        this.airplaneNumber = airplaneNumber;
    }

    public static void setPlanNumber(int planNumber) {
        Airplane.planNumber = planNumber;
    }

    void setIdNumber(int idNumber) {
        this.airplaneNumber = idNumber;
    }

    public boolean getPlaneStatus() {
        int seatCount = 0;
        for (int i = 0; i < passengerSeats.length; i++) {
            if (passengerSeats[i] != null) {
                seatCount++;
            }
        }
        if (seatCount >= seatingCapacity) {
            this.planeStatus = false;
        }
        else {
            this.planeStatus = true;
        }
        return planeStatus;
    }

    String getManufacturerName() {
        return manufacturerName;
    }

    String getModelName() {
        return modelName;
    }

    String getTailNumber() {
        return tailNumber;
    }

    int getSeatingCapacity() {
        return seatingCapacity;
    }

    double getMaxAirSpeed() {
        return maxAirSpeed;
    }

    public boolean[] getSeatsAvailable() {
        return seatsAvailable;
    }

    Passenger[] getPassengerSeats() {
        return passengerSeats;
    }

    public int getIdNumber() {
        return airplaneNumber;
    }

    public int getAirplaneNumber() {
        return airplaneNumber;
    }

    public static int getPlanNumber() {
        return planNumber;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "airplaneNumber=" + airplaneNumber +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", tailNumber='" + tailNumber + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", maxAirSpeed=" + maxAirSpeed +
                ", seatsAvailable=" + Arrays.toString(seatsAvailable) +
                ", passengerSeats=" + Arrays.toString(passengerSeats) +
                ", destinationCode='" + destinationCode + '\'' +
                '}';
    }
}
