package challenges.datastructures.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("solve")
    void solve(String expected, String input) {
        InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        Solution.solve(is, ps);
        String content = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(expected, content);
    }

    private static Stream<Arguments> solve() {
        return Stream.of(
                Arguments.of("5 1 2 3 4 ", "5 4\n1 2 3 4 5"),
                Arguments.of("4 5 1 2 3 ", "5 3\n1 2 3 4 5"),
                Arguments.of("2 3 4 5 1 ", "5 1\n1 2 3 4 5"),
                Arguments.of("1 ", "1 1\n1"),
                Arguments.of("1 2 3 4 5 ", "5 5\n1 2 3 4 5"),
                Arguments.of("2 3 4 5 1 ", "5 6\n1 2 3 4 5")
        );
    }
}