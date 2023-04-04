package cs2040s;

public interface OrderStatisticsTreeSet<T extends Comparable<? super T>> extends TreeSet<T> {
    /**
     * Return the rank of the given element in the set
     * @param elem the element for comparison
     * @return the rank of the element, or null if the element is not in the set
     */
    public Integer rank(T elem);
}
