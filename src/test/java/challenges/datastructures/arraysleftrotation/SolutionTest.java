package challenges.datastructures.arraysleftrotation;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void solve() {
        String input;
        InputStream is;
        ByteArrayOutputStream baos;
        PrintStream ps;
        String content;

        input = "5 4\n" +
                "1 2 3 4 5";
        is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        baos = new ByteArrayOutputStream();
        ps = new PrintStream(baos);
        Solution.solve(is, ps);
        content = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals("5 1 2 3 4 ", content);

        input = "5 3\n" +
                "1 2 3 4 5";
        is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        baos = new ByteArrayOutputStream();
        ps = new PrintStream(baos);
        Solution.solve(is, ps);
        content = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals("4 5 1 2 3 ", content);
    }
}