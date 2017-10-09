package challenges.datastructures.treesisthisabinarysearchtree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @ParameterizedTest
    @MethodSource("checkNormalBST")
    void checkNormalBST(Node root) {
        assertTrue(Solution.checkBST(root));
    }

    @ParameterizedTest
    @MethodSource("checkBSTWithWrongOrder")
    void checkBSTWithWrongOrder(Node root) {
        assertFalse(Solution.checkBST(root));
    }

    @ParameterizedTest
    @MethodSource("checkBSTWithNonUnique")
    void checkBSTWithNonUnique(Node root) {
        assertFalse(Solution.checkBST(root));
    }

    private static Stream<Arguments> checkNormalBST() {
        return Stream.of(
                Arguments.of(Node.createBinaryTree(1, 2, 3, 4, 5, 6, 7))
        );
    }

    private static Stream<Arguments> checkBSTWithWrongOrder() {
        return Stream.of(
                Arguments.of(Node.createBinaryTree(1, 2, 4, 3, 5, 6, 7)),
                Arguments.of(Node.createBinaryTree(8, 2, 3, 4, 5, 6, 7)),
                Arguments.of(Node.createBinaryTree(1, 2, 3, 4, 5, 7, 6))
        );
    }

    private static Stream<Arguments> checkBSTWithNonUnique() {
        return Stream.of(
                Arguments.of(Node.createBinaryTree(1, 3, 3, 4, 5, 6, 7)),
                Arguments.of(Node.createBinaryTree(1, 2, 3, 4, 5, 6, 6)),
                Arguments.of(Node.createBinaryTree(1, 2, 3, 5, 5, 6, 6))
        );
    }

}