package cs2040s;

public interface TreeSet<T extends Comparable<? super T>> extends Set<T> {
    /**
     * Return the greatest element smaller than or equal to the given element
     * @param elem the element for comparison
     * @return the floor of the element, or null if there is not any
     */
    public T floor(T elem);

    /**
     * Return the greatest element strictly smaller than the given element
     * @param elem the element for comparison
     * @return the greatest element smaller than the given, or null if there is not any
     */
    public T lower(T elem);

    /**
     * Return the smallest element greater than or equal to the given element
     * @param elem the element for comparison
     * @return the ceiling of the element, or null if there is not any
     */
    public T ceil(T elem);

    /**
     * Return the smallest element strictly greater than to the given element
     * @param elem the element for comparison
     * @return the smallest element greater than the given, or null if there is not any
     */
    public T higher(T elem);

    /**
     * Return the lowest element in the set
     * @return the smallest element, or null if the set is empty
     */
    public T lowest();

    /**
     * Return the greatest element in the set
     * @return the greatest element, or null if the set is empty
     */
    public T highest();
}
