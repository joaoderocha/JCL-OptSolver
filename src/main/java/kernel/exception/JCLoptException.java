package kernel.exception;

public class JCLoptException extends Exception {
   
    private static final long serialVersionUID = -5785390692275103944L;

    public JCLoptException() {
        super();
    }

    public JCLoptException(String message){
        super(message);
    }

    public JCLoptException(Throwable cause) {
        super(cause);
    }

    public JCLoptException(String message, Throwable cause) {
        super(message, cause);
    }

    public JCLoptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
