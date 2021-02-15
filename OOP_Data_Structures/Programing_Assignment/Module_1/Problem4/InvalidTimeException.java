/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 09/30/2020
 *
 * InvalidTimeException.java
 *
 *
 */
public class InvalidTimeException extends Exception {

    public InvalidTimeException() {
        super("ERROR: Time entered not valid, Enter 1 through 6");
    }

    public InvalidTimeException(String message) {
        super(message);
    }
}
