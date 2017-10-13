package challenges.datastructures.heaps;

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
        String input = "6\n12\n4\n5\n3\n8\n7";
        String expected = "12.0\r\n8.0\r\n5.0\r\n4.5\r\n5.0\r\n6.0\r\n";
        InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Solution.solve();

        String content = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(expected, content);
    }

}