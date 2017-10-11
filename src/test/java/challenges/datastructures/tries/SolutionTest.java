package challenges.datastructures.tries;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @ParameterizedTest
    @MethodSource("solve")
    void solve(String input, String expected) {
        InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        Solution.solve(is, ps);
        String content = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(expected, content);
    }

    private static Stream<Arguments> solve() {
        return Stream.of(
                Arguments.of("4\n" + "add hack\n" + "add hackerrank\n" + "find hac\n" + "find hak",
                             "2\r\n" + "0\r\n")
        );
    }

}