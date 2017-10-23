package challenges.algorithms.binarysearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IceCreamTest {

    @Test
    void sort() {
        IceCream ic11 = new IceCream(1, 1);
        IceCream ic24 = new IceCream(2, 4);
        IceCream ic35 = new IceCream(3, 5);
        IceCream ic43 = new IceCream(4, 3);
        IceCream ic52 = new IceCream(5, 2);

        IceCream[] arr = new IceCream[] {ic11, ic24, ic35, ic43, ic52};
        IceCream[] sortedArray = new IceCream[] {ic11, ic52, ic43, ic24, ic35};
        Arrays.sort(arr);
        assertArrayEquals(sortedArray, arr);
    }

}