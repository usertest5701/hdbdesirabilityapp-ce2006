package ntu.ce2006.swensens.hdbdesirabilityapp.exceptions;

/**
 * Created by Swensens on 20/03/17.
 */

public class APIErrorException extends Exception {
    public APIErrorException(String message) {
        super(message);
    }
}