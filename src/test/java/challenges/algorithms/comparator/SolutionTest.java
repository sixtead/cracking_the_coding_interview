package challenges.algorithms.comparator;

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
        String input = "5\n" +
                        "amy 100\n" +
                        "david 100\n" +
                        "heraldo 50\n" +
                        "aakansha 75\n" +
                        "aleksa 150";
        String expected = "aleksa 150\n" +
                            "amy 100\n" +
                            "david 100\n" +
                            "aakansha 75\n" +
                            "heraldo 50\n";
        InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        System.setIn(is);
        System.setOut(ps);

        Solution.solve();

        String output = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(expected, output);
    }

}