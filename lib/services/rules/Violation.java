public class Violation {

    private final String message;

    private Violation(String _message) {
        this.message = _message;
    }

    public static Violation of(String message) {
        return new Violation(message);
    }

    public String getMessage() {
        return this.message;
    }
}
