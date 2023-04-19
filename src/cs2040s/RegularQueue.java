package cs2040s;

public class RegularQueue<T> {
    T[] arr;
    int start = 0;
    int end = 0;

    private static double MAX_LOAD = 1;
    private static double MIN_LOAD = 0.25;
    private static int MIN_SIZE = 2;

    public RegularQueue(int initialSize) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[initialSize];
        this.arr = temp;
    }

    private void changeSize(int newSize) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[newSize];
        T[] oldArr = this.arr;
        this.arr = temp;
        for (int i = 0; i < Math.min(oldArr.length, newSize); i++) {
            this.arr[i] = oldArr[(this.start + i) % oldArr.length];
        }
        this.end = this.size();
        this.start = 0;
    }

    public void enq(T elem) {
        this.arr[this.end] = elem;
        this.end = (this.end + 1) % this.arr.length;
        if (((double) this.size()) / this.arr.length >= RegularQueue.MAX_LOAD) {
            this.changeSize(this.arr.length * 2);
        }
    }

    public T deq() {
        T result = this.arr[this.start];
        this.arr[this.start] = null;
        this.start = (this.start + 1) % this.arr.length;
        if (((double) this.size()) / this.arr.length <= RegularQueue.MIN_LOAD &
                this.arr.length / 2 >= RegularQueue.MIN_SIZE) {
            this.changeSize(this.arr.length / 2);
        }
        return result;
    }

    public int size() {
        return (this.end + this.arr.length - this.start) % this.arr.length;
    }
}
