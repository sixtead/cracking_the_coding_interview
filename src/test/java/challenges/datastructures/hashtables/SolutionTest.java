package challenges.datastructures.hashtables;

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
        System.setIn(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Solution.solve();

        String output = new String(baos.toByteArray(), StandardCharsets.UTF_8);

        assertEquals(expected, output);
    }

    private static Stream<Arguments> solve() {
        return Stream.of(
                Arguments.of("Yes\r\n", "6 4\n" +
                                    "give me one grand today night\n" +
                                    "give one grand today"),
                Arguments.of("No\r\n", "6 5\n" +
                                    "two times three is not four\n" +
                                    "two times two is four")
        );
    }

}