package kernel.exception;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JCLoptExceptionTest {

    @Test
    public void msgTest() {
        try {
            throw new JCLoptException("msg");
        } catch (final JCLoptException error) {
            assertEquals(error.getMessage(), "msg");
        }
    }

    @Test
    public void throwableTest() {
        final Throwable cause = new Throwable();
        try {
            throw new JCLoptException(cause);
        } catch (final JCLoptException error) {
            assertEquals(error.getCause(), cause);
        }
    }

    @Test
    public void msgThrowableTest() {
        final Throwable cause = new Throwable();
        try {
            throw new JCLoptException("msg", cause);
        } catch (final JCLoptException error) {
            assertEquals(error.getMessage(), "msg");
            assertEquals(error.getCause(), cause);
        }
    }

    @Test
    public void Test() {
        final Throwable cause = new Throwable();
        try {
            throw new JCLoptException("msg", cause, true, true);
        } catch (final JCLoptException error) {
            assertEquals(error.getMessage(), "msg");
            assertEquals(error.getCause(), cause);
        }
    }
}
