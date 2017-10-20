package challenges.algorithms.bubble;

import org.junit.jupiter.api.Test;
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
    void solve(String expected, String input) {
        InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setIn(is);
        System.setOut(ps);

        Solution.solve();

        String output = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(expected, output);
    }

    private static Stream<Arguments> solve() {
        return Stream.of(
                Arguments.of("Array is sorted in 0 swaps.\r\n" +
                                "First Element: 1\r\n" +
                                "Last Element: 3\r\n",
                            "3\n" +
                                "1 2 3"),
                Arguments.of("Array is sorted in 3 swaps.\r\n" +
                                "First Element: 1\r\n" +
                                "Last Element: 3\r\n",
                            "3\n" +
                                "3 2 1")
        );
    }

}