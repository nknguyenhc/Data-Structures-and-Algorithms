package cs2040s;

/**
 * This class contains sorters, which are static methods only.
 * Methods without "in-place" in name sorts the input and return nothing.
 * Methods with "in-place" in name returns the sorted array and leave the input intact.
 * All sortings are done in descending order.
 */
public class Sorters {
    public static <T extends Comparable<? super T>> T[] heapSort(T[] arr) {
        T[] copy = arr.clone();
        BinaryHeap<T> heap = BinaryHeap.heapify(copy);
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Comparable<?>[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = heap.extractMax();
        }
        return result;
    }
}
