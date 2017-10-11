package challenges.datastructures.stacks;

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
    @Test
    void solve() {
        String input = "3\n{[()]}\n{[(])}\n{{[[(())]]}}";
        InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        Solution.solve(is, ps);

        String actual = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals("YES\r\nNO\r\nYES\r\n", actual);
    }

    @ParameterizedTest
    @MethodSource("isBalancedTrue")
    void isBalancedTrue(String str) {
        assertTrue(Solution.isBalanced(str));
    }

    private static Stream<Arguments> isBalancedTrue() {
        return Stream.of(
                Arguments.of("{[()]}"),
                Arguments.of("{{[[(())]]}}")
        );
    }

    @ParameterizedTest
    @MethodSource("isBalancedFalse")
    void isBalancedFalse(String str) {
        assertFalse(Solution.isBalanced(str));
    }

    private static Stream<Arguments> isBalancedFalse() {
        return Stream.of(
                Arguments.of("{[(])}")
        );
    }
}