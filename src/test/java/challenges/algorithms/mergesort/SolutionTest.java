package challenges.algorithms.mergesort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void solve() {
        InputStream is;
        String input = "2\n" +
                        "5\n" +
                        "1 1 1 2 2\n" +
                        "5\n" +
                        "2 1 3 1 2";
        String expected = "0\r\n" +
                            "4\r\n";
        is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        try {
            is = new FileInputStream("D://java//CrackingTheCodingInterview//src//main//java//challenges//algorithms//mergesort//input01.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            expected = new Scanner(new File("D://java//CrackingTheCodingInterview//src//main//java//challenges//algorithms//mergesort//output01.txt")).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        System.setIn(is);
        System.setOut(ps);

        Solution.solve();

        String output = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(expected, output.trim());
    }

    @ParameterizedTest
    @MethodSource("countInversions")
    void countInversions(int expected, int[] array) {
        assertEquals(expected, Solution.countInversions(array));
    }

    private static Stream<Arguments> countInversions() {
        return Stream.of(
                Arguments.of(0, new int[] {1, 1, 1, 2, 2}),
                Arguments.of(4, new int[] {2, 1, 3, 1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("mergeSort")
    void customMergeSort(int[] expected, int[] actual) {
        int[] aux = actual.clone();
        Solution.mergeSort(actual, aux, 0, actual.length - 1);
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> mergeSort() {
        return Stream.of(
                Arguments.of(new int[] {3, 9, 10, 27, 38, 43, 82}, new int[] {38, 27, 43, 3, 9, 82, 10}),
                Arguments.of(new int[] {7, 9, 12, 26, 28, 35, 87}, new int[] {12, 35, 87, 26, 9, 28, 7}),
                Arguments.of(new int[] {1, 1, 1, 2, 2}, new int[] {1, 1, 1, 2, 2}),
                Arguments.of(new int[] {1, 1, 2, 2, 3}, new int[] {2, 1, 3, 1, 2})
        );
    }

    @Test
    void randomMergeSort() {
        for(int i = 0; i < 100; i++) {
            int[] arrayA = generateArray(500);
            int[] aux = arrayA.clone();
            int[] arrayB = Arrays.copyOf(arrayA, 500);

            assertArrayEquals(arrayA, arrayB);
            Solution.mergeSort(arrayA, aux, 0, 499);
            Arrays.sort(arrayB);
            assertArrayEquals(arrayA, arrayB);
        }
    }

    private int[] generateArray(int n) {
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }
        return array;
    }

}