package challenges.datastructures.strings;

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
    void solve(String input, String expected) {
        String output;
        InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setIn(is);
        System.setOut(ps);

        Solution.solve();

        output = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(expected, output);
    }

    private static Stream<Arguments> solve() {
        return Stream.of(
                Arguments.of("cde\nabc", "4\r\n"),
                Arguments.of("bacdc\ndcbad", "2\r\n")
        );
    }

    @ParameterizedTest
    @MethodSource("numberNeeded")
    void numberNeeded(int expected, String firstString, String secondString) {
        assertEquals(expected, Solution.numberNeeded(firstString, secondString));
    }

    private static Stream<Arguments> numberNeeded() {
        return Stream.of(
                Arguments.of(4, "cde", "abc"),
                Arguments.of(2, "bacdc", "dcbad")
        );
    }

}