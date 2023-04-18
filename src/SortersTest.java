import cs2040s.Sorters;
import static org.junit.Assert.*;
import org.junit.Test;

public class SortersTest {
    @Test
    public void test1() {
        Integer[] input = new Integer[] {0, 1, 4, 7, 2, 5, 3, 6, 9, 10};
        assertArrayEquals(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 9, 10}, Sorters.heapSort(input));
        assertArrayEquals(new Integer[] {0, 1, 4, 7, 2, 5, 3, 6, 9, 10}, input);
    }

    @Test
    public void test2() {
        Integer[] input = new Integer[] {0, 5, 3, 0};
        assertArrayEquals(new Integer[] {0, 0, 3, 5}, Sorters.heapSort(input));
        assertArrayEquals(new Integer[] {0, 5, 3, 0}, input);
    }

    @Test
    public void noElem() {
        Integer[] input = new Integer[] {};
        assertArrayEquals(new Integer[] {}, Sorters.heapSort(input));
        assertArrayEquals(new Integer[] {}, input);
    }

    @Test
    public void oneElem() {
        Integer[] input = new Integer[] {5};
        assertArrayEquals(new Integer[] {5}, Sorters.heapSort(input));
        assertArrayEquals(new Integer[] {5}, Sorters.heapSort(input));
    }
}
