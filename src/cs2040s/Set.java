package cs2040s;

public interface Set<T> {
    /**
     * Add the element to the set.
     * @param elem the element to be added
     */
    public void add(T elem);

    /**
     * Check if an element is in the set.
     * @param elem the element to compare
     * @return true if the element is in the set
     */
    public boolean contains(T elem);

    /**
     * Return the address object that is equal (qualified by Object.equals(Object)) to the given element.
     * @param elem the element to compare
     * @return the address object, or null if the element does not exist
     */
    public T object(T elem);

    /**
     * Remove the element from the set.
     * @param elem the element to be removed
     * @return true if the element was previously in the set
     */
    public boolean remove(T elem);

    /**
     * Return the size of the set.
     * @return the size of the set
     */
    public int size();
}
