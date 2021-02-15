package Mod1GA;
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 09/26/2020
 *
 * SSNLengthException.java
 *
 * This class represents the driver for the EmployeeException class.
 * The driver program uses an array that can hold up to 100 employees (
 * the array will be of EmployeeException type).
 * The user should be free to enter as many employees as needed.
 * The driver class should use two exception classes to signal the user that the SSN entered is not correct. * SSN needs to be entered as a  9-digit string without separators.
 */
public class SSNLengthException extends Exception{
    public SSNLengthException() {
        super("Exception: SSN must be 9 digits in length");
    }
    public SSNLengthException(String message) {
        super(message);
    }
}
