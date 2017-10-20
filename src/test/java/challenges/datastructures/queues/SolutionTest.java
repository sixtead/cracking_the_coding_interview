package challenges.datastructures.queues;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void solve() {
        String input =  "10\n" +
                        "1 42\n" +
                        "2\n" +
                        "1 14\n" +
                        "3\n" +
                        "1 28\n" +
                        "3\n" +
                        "1 60\n" +
                        "1 78\n" +
                        "2\n" +
                        "2";
        InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        System.setIn(is);
        System.setOut(ps);

        Solution.solve();

        String output = new String(baos.toByteArray(), StandardCharsets.UTF_8);

        assertEquals("14\r\n14\r\n", output);
    }

}