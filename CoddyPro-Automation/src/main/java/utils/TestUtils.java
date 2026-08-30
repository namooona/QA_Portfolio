package utils;

public class TestUtils {

    // Pauses execution for the given number of milliseconds.
    // Used only to slow things down for visual observation — not for real waits.
    public static void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
