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

    private static <T> void swap(T[] arr, int i1, int i2) {
        T temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static <T extends Comparable<? super T>> void inplaceInsertionSort(T[] arr, int numSwaps) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int curr = i;
            while (curr > 0) {
                if (arr[curr].compareTo(arr[curr - 1]) <= 0) {
                    break;
                }
                Sorters.swap(arr, curr, curr - 1);
                count += 1;
                if (count == numSwaps) {
                    break;
                }
                curr -= 1;
            }
            if (count == numSwaps) {
                break;
            }
        }
    }

    public static <T extends Comparable<? super T>> void inplaceInsertionSort(T[] arr) {
        Sorters.inplaceInsertionSort(arr, arr.length * arr.length);
    }

    public static <T extends Comparable<? super T>> void inplaceSelectionSort(T[] arr, int numSwaps) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int greatestI = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[greatestI]) > 0) {
                    greatestI = j;
                }
            }
            if (greatestI != i) {
                Sorters.swap(arr, greatestI, i);
                count += 1;
            }
            if (count == numSwaps) {
                break;
            }
        }
    }

    public static <T extends Comparable<? super T>> void inplaceSelectionSort(T[] arr) {
        Sorters.inplaceSelectionSort(arr, arr.length);
    }

    public static <T extends Comparable<? super T>> void inplaceQuickSort(T[] arr, int numSwaps) {

    }
}
