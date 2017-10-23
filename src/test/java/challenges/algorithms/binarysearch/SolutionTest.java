package challenges.algorithms.binarysearch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void solve() {
        String input = "2\n" +
                        "4\n" +
                        "5\n" +
                        "1 4 5 3 2\n" +
                        "4\n" +
                        "4\n" +
                        "2 2 4 3";
        String expected = "1 4\r\n" +
                          "1 2\r\n";
        InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        System.setIn(is);
        System.setOut(ps);

        Solution.solve();

        String output = new String(baos.toByteArray(), StandardCharsets.UTF_8);

        assertEquals(expected, output);
    }

    @ParameterizedTest
    @MethodSource("binarySearch")
    void binarySearch(int expected, int actual) {
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> binarySearch() {
        IceCream ic11 = new IceCream(1, 1);
        IceCream ic24 = new IceCream(2, 4);
        IceCream ic35 = new IceCream(3, 5);
        IceCream ic43 = new IceCream(4, 3);
        IceCream ic52 = new IceCream(5, 2);

        IceCream[] arr = new IceCream[] {ic11, ic24, ic35, ic43, ic52};
        Arrays.sort(arr);

        return Stream.of(
                Arguments.of(1, Solution.binarySearch(0, arr.length - 1, arr, 1)),
                Arguments.of(2, Solution.binarySearch(0, arr.length - 1, arr, 4)),
                Arguments.of(3, Solution.binarySearch(0, arr.length - 1, arr, 5)),
                Arguments.of(4, Solution.binarySearch(0, arr.length - 1, arr, 3)),
                Arguments.of(5, Solution.binarySearch(0, arr.length - 1, arr, 2))
        );
    }

}