package cs2040s;

/**
 * Support inserting elements and taking elements from the set based on priority.
 * The largest elements are taken first, based on Comparable::compareTo
 * @param <T> the type of elements in this priority queue.
 */
public interface PriorityQueue<T extends Comparable<? super T>> {
    /**
     * Add the given element to the queue, allowing duplicates.
     * @param elem the new element
     */
    public void add(T elem);

    /**
     * Remove the largest element from the queue, return the element.
     * @return the largest element from the queue
     */
    public T extractMax();

    /**
     * Return the size of the queue.
     * @return the number of elements in the queue
     */
    public int size();
}
