package cs2040s;

public class FixedSizeQueue<T> {
    T[] arr;
    int start = 0;
    int end = 0;

    public FixedSizeQueue(int size) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[size];
        this.arr = temp;
    }

    public void enq(T elem) {
        this.arr[this.end] = elem;
        this.end = (this.end + 1) % this.arr.length;
    }

    public T deq() {
        T result = this.arr[this.start];
        this.start = (this.start + 1) % this.arr.length;
        return result;
    }

    public int size() {
        return (this.end + this.arr.length - this.start) % this.arr.length;
    }
}
