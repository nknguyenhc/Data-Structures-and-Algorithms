import static org.junit.Assert.*;

public class MedianFindingSolutionTest {
    @org.junit.Test
    public void test1() {
        MedianFindingSolution finder = new MedianFindingSolution();
        finder.insert(4);
        finder.insert(2);
        finder.insert(3);
        assertEquals(3, finder.getMedian());
        finder.insert(8);
        finder.insert(2);
        finder.insert(7);
        finder.insert(1);
        assertEquals(4, finder.getMedian());
        assertEquals(2, finder.getMedian());
    }

    @org.junit.Test
    public void test2() {
        System.out.println("Test 2");
        MedianFindingSolution finder = new MedianFindingSolution();
        finder.insert(4);
        finder.insert(2);
        finder.insert(3);
        finder.insert(1);
        assertEquals(3, finder.getMedian());
        assertEquals(2, finder.getMedian());
        assertEquals(4, finder.getMedian());
        assertEquals(1, finder.getMedian());
    }
}
