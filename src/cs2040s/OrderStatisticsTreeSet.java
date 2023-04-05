package cs2040s;

public interface OrderStatisticsTreeSet<T extends Comparable<? super T>> extends TreeSet<T> {
    /**
     * Return the rank of the given element in the set.
     * This operation takes O(log n) time.
     * This is because it takes time to find the element in the set.
     * @param elem the element for comparison
     * @return the rank of the element, or null if the element is not in the set
     */
    public Integer rank(T elem);

    /**
     * Return the rank of the reference object in the set.
     * This operation takes O(1) time, since the reference is already found.
     * @param elem the reference to check rank
     * @return the rank of the element, or null if the element is not in the set
     */
    public Integer rankByReference(T elem);
}
