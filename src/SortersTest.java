import cs2040s.Sorters;
import static org.junit.Assert.*;
import org.junit.Test;

public class SortersTest {
    @Test
    public void test1() {
        Integer[] input = new Integer[] {0, 1, 4, 7, 2, 5, 3, 6, 9, 10};
        assertArrayEquals(new Integer[] {10, 9, 7, 6, 5, 4, 3, 2, 1, 0}, Sorters.heapSort(input));
        assertArrayEquals(new Integer[] {0, 1, 4, 7, 2, 5, 3, 6, 9, 10}, input);
        Integer[] insertionInput = input.clone();
        Sorters.inplaceInsertionSort(insertionInput, 5);
        assertArrayEquals(new Integer[] {4, 7, 1, 0, 2, 5, 3, 6, 9, 10}, insertionInput);
        Sorters.inplaceInsertionSort(insertionInput, 2);
        assertArrayEquals(new Integer[] {7, 4, 1, 2, 0, 5, 3, 6, 9, 10}, insertionInput);
        Integer[] selectionInput = input.clone();
        Sorters.inplaceSelectionSort(selectionInput, 4);
        assertArrayEquals(new Integer[] {10, 9, 7, 6, 2, 5, 3, 4, 1, 0}, selectionInput);
        Sorters.inplaceSelectionSort(selectionInput, 1);
        assertArrayEquals(new Integer[] {10, 9, 7, 6, 5, 2, 3, 4, 1, 0}, selectionInput);
    }

    @Test
    public void test2() {
        Integer[] input = new Integer[] {0, 5, 3, 0};
        assertArrayEquals(new Integer[] {5, 3, 0, 0}, Sorters.heapSort(input));
        assertArrayEquals(new Integer[] {0, 5, 3, 0}, input);
        Integer[] insertionInput = input.clone();
        Sorters.inplaceInsertionSort(insertionInput, 2);
        assertArrayEquals(new Integer[] {5, 3, 0, 0}, insertionInput);
        Integer[] selectionInput = input.clone();
        Sorters.inplaceSelectionSort(selectionInput, 1);
        assertArrayEquals(new Integer[] {5, 0, 3, 0}, selectionInput);
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
        assertArrayEquals(new Integer[] {5}, input);
    }

    @Test
    public void twoElems1() {
        Integer[] input = new Integer[] {3, 4};
        assertArrayEquals(new Integer[] {4, 3}, Sorters.heapSort(input));
        assertArrayEquals(new Integer[] {3, 4}, input);
    }

    @Test
    public void twoElems2() {
        Integer[] input = new Integer[] {4, 3};
        assertArrayEquals(new Integer[] {4, 3}, Sorters.heapSort(input));
        assertArrayEquals(new Integer[] {4, 3}, input);
    }
}
