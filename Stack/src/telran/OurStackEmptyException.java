package telran;

public class OurStackEmptyException extends RuntimeException {
    public OurStackEmptyException() {
        super();
    }

    public OurStackEmptyException(String message) {
        super(message);
    }

}
