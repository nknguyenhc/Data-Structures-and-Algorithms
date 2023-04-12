package cs2040s;

public class ChainingHashSet<T extends ChainingHashNode> implements Set<T> {
    private static class Control {
        public ChainingHashNode first;

        public void add(T elem) {
            elem.next = this.first;
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
        this.table = new Control[initialCapacity];
    }

    private int hash(T elem) {
        return elem.hashCode() % this.table.length;
    }

    private T getFirst(Control control) {
        @SuppressWarnings("unchecked")
        T first = (T) control.first;
        return first;
    }

    private T getNext(T node) {
        @SuppressWarnings("unchecked")
        T next = (T) node.next;
        return next;
    }

    @Override
    public boolean contains(T elem) {
        int hashValue = this.hash(elem);
        T curr = this.getFirst(this.table[hashValue]);
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
        T curr = this.getFirst(this.table[hashValue]);
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
    }
}
