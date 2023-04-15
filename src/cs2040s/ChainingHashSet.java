package cs2040s;

/**
 * Implementation of a hash table using chaining.
 * To indicate the type, make sure to inherit from ChainingHashNode.
 * @param <T> type of elements in the set, subtype of ChainingHashNode
 */
public class ChainingHashSet<T extends ChainingHashNode> implements Set<T> {
    private class Control {
        public T first;

        public void add(T elem) {
            elem.next = this.first;
            elem.last = null;
            if (this.first != null) {
                this.first.last = elem;
            }
            this.first = elem;
        }
    }

    Control[] table;
    int elemCount = 0;
    private static int MIN_TABLE_SIZE = 2;
    private static double UPSIZING_LOAD_FACTOR = 1;
    private static double DOWNSIZING_LOAD_FACTOR = 0.25;

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
        if (elem.set == this) {
            return;
        }
        int hashValue = this.hash(elem);
        this.table[hashValue].add(elem);
        elem.set = this;
        this.elemCount += 1;
        if (((double) this.elemCount) / this.table.length >= ChainingHashSet.UPSIZING_LOAD_FACTOR) {
            this.changeTableSize(this.table.length * 2);
        }
    }

    private void changeTableSize(int newSize) {
        Control[] oldTable = this.table;
        @SuppressWarnings("unchecked")
        Control[] temp = (Control[]) new Object[newSize];
        this.table = temp;
        for (Control control: oldTable) {
            T curr = control.first;
            while (curr != null) {
                this.add(curr);
                curr = this.getNext(curr);
            }
        }
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
            if (((double) this.elemCount) / this.table.length <= ChainingHashSet.DOWNSIZING_LOAD_FACTOR
                    & this.table.length / 2 >= ChainingHashSet.MIN_TABLE_SIZE) {
                this.changeTableSize(this.table.length / 2);
            }
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
