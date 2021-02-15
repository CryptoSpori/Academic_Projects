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
public class TimeInUseException extends Exception {

    public TimeInUseException() {

        super("ERROR: Time you entered is in use!");

    }

    public TimeInUseException(String message) {
        super(message);
    }
}
