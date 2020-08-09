package telran;

public class OurStackOverflowException extends RuntimeException {

    public OurStackOverflowException() {
        super();
    }

    public OurStackOverflowException(String message) {
        super(message);
    }
}
