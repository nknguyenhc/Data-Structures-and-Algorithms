package cs2040s;

/**
 * This class uses binary heap to implement priority queue.
 * @param <T> the type of elements in the heap
 */
public class BinaryHeap<T extends Comparable<? super T>> implements PriorityQueue<T> {
    T[] arrRep;
    int size = 0;
    int currCap;
    private static int MINIMUM_TABLE_SIZE = 8;
    private static double UPSIZING_LOAD_FACTOR = 1.0;
    private static double DOWNSIZING_LOAD_FACTOR = 0.25;

    public BinaryHeap() {
        this(BinaryHeap.MINIMUM_TABLE_SIZE);
    }

    public BinaryHeap(int initialSize) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable<?>[initialSize];
        this.arrRep = temp;
        this.currCap = initialSize;
    }

    private static int parentI(int childI) {
        return (childI - 1) / 2;
    }

    private static int child1I(int parentI) {
        return parentI * 2 + 1;
    }

    private static int child2I(int parentI) {
        return parentI * 2 + 2;
    }

    private void changeSize(int newSize) {
        T[] oldArr = this.arrRep;
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[newSize];
        this.arrRep = temp;
        int smallerSize = Math.min(oldArr.length, newSize);
        for (int i = 0; i < smallerSize; i++) {
            this.arrRep[i] = oldArr[i];
        }
    }

    private void swap(int i1, int i2) {
        T temp = this.arrRep[i1];
        this.arrRep[i1] = this.arrRep[i2];
        this.arrRep[i2] = temp;
    }

    private void bubbleUp(int startingI) {
        int currI = startingI;
        while (currI != 0) {
            int parentI = BinaryHeap.parentI(currI);
            if (this.arrRep[parentI].compareTo(this.arrRep[currI]) < 0) {
                this.swap(parentI, currI);
                currI = parentI;
            } else {
                break;
            }
        }
    }

    @Override
    public void add(T elem) {
        if (((double) this.size) / this.currCap >= BinaryHeap.UPSIZING_LOAD_FACTOR) {
            this.changeSize(this.currCap * 2);
        }
        this.arrRep[this.size] = elem;
        this.bubbleUp(this.size);
        this.size++;
    }

    private void bubbleDown(int startI) {
        int currI = startI;
        int child1I = BinaryHeap.child1I(currI);
        while (child1I < this.size) {
            if (child1I == this.size - 1) {
                if (this.arrRep[currI].compareTo(this.arrRep[child1I]) < 0) {
                    this.swap(currI, child1I);
                }
                break;
            } else {
                int child2I = BinaryHeap.child2I(currI);
                if (this.arrRep[currI].compareTo(this.arrRep[child1I]) < 0) {
                    if (this.arrRep[currI].compareTo(this.arrRep[child2I]) < 0) {
                        if (this.arrRep[child1I].compareTo(this.arrRep[child2I]) > 0) {
                            this.swap(currI, child1I);
                            currI = child1I;
                            child1I = BinaryHeap.child1I(currI);
                        } else {
                            this.swap(currI, child2I);
                            currI = child2I;
                            child1I = BinaryHeap.child1I(currI);
                        }
                    } else {
                        this.swap(currI, child1I);
                        currI = child1I;
                        child1I = BinaryHeap.child1I(currI);
                    }
                } else if (this.arrRep[currI].compareTo(this.arrRep[child2I]) < 0) {
                    this.swap(currI, child2I);
                    currI = child2I;
                    child1I = BinaryHeap.child1I(currI);
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public T extractMax() {
        if (this.size == 0) {
            return null;
        }
        T result = this.arrRep[0];
        this.arrRep[0] = this.arrRep[this.size - 1];
        this.arrRep[this.size - 1] = null;
        this.size -= 1;
        this.bubbleDown(0);
        if (((double) this.size) / this.currCap <= BinaryHeap.DOWNSIZING_LOAD_FACTOR
                & this.currCap / 2 >= BinaryHeap.MINIMUM_TABLE_SIZE) {
            this.changeSize(this.currCap / 2);
        }
        return result;
    }

    public static <T extends Comparable<? super T>> BinaryHeap<T> heapify(T[] arr) {
        BinaryHeap<T> heap = new BinaryHeap<>();
        heap.arrRep = arr;
        heap.size = arr.length;
        heap.currCap = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            heap.bubbleDown(i);
        }
        return heap;
    }

    @Override
    public int size() {
        return this.size;
    }
}
