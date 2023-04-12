package cs2040s;

public class ChainingHashSet<T extends ChainingHashNode> implements Set<T> {
    private class Control {
        public T first;

        public void add(T elem) {
            elem.next = this.first;
            this.first.last = elem;
            this.first = elem;
        }
    }

    Control[] table;
    int elemCount = 0;
    private static int MIN_TABLE_SIZE = 2;

    public ChainingHashSet() {
        this(2);
    }

    public ChainingHashSet(int initialCapacity) {
        @SuppressWarnings("unchecked")
        Control[] temp = (Control[]) new Object[initialCapacity];
        for (int i = 0; i < initialCapacity; i++) {
            temp[i] = new Control();
        }
        this.table = temp;
    }

    private int hash(T elem) {
        return elem.hashCode() % this.table.length;
    }

    private T getNext(T node) {
        @SuppressWarnings("unchecked")
        T next = (T) node.next;
        return next;
    }

    private T getLast(T node) {
        @SuppressWarnings("unchecked")
        T last = (T) node.last;
        return last;
    }

    @Override
    public boolean contains(T elem) {
        int hashValue = this.hash(elem);
        T curr = this.table[hashValue].first;
        while (curr != null) {
            if (curr.equals(elem)) {
                return true;
            }
            curr = this.getNext(curr);
        }
        return false;
    }

    @Override
    public T object(T elem) {
        int hashValue = this.hash(elem);
        T curr = this.table[hashValue].first;
        while (curr != null) {
            if (curr.equals(elem)) {
                return curr;
            }
            curr = this.getNext(curr);
        }
        return null;
    }

    @Override
    public boolean containsReference(T elem) {
        return elem.set == this;
    }

    @Override
    public void add(T elem) {
        int hashValue = this.hash(elem);
        this.table[hashValue].add(elem);
        elem.set = this;
        this.elemCount += 1;
    }

    @Override
    public boolean removeByReference(T elem) {
        if (elem.set == this) {
            this.getLast(elem).next = this.getNext(elem);
            this.getNext(elem).last = this.getLast(elem);
            elem.last = null;
            elem.next = null;
            elem.set = null;
            this.elemCount--;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(T elem) {
        T ref = this.object(elem);
        if (ref != null) {
            return this.removeByReference(ref);
        }
        return false;
    }

    @Override
    public int size() {
        return this.elemCount;
    }
}
