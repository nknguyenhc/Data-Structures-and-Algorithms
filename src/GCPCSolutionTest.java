import static org.junit.Assert.*;

public class GCPCSolutionTest {

    @org.junit.Test
    public void update1() {
        GCPCSolution soln = new GCPCSolution(3);
        assertEquals(1, soln.update(1, 6));
        assertEquals(2, soln.update(3, 5));
        assertEquals(2, soln.update(2, 7));
        assertEquals(1, soln.update(1, 9));
    }

    @org.junit.Test
    public void update2() {
        GCPCSolution soln = new GCPCSolution(5);
        assertEquals(2, soln.update(2, 2));
        assertEquals(2, soln.update(2, 4));
        assertEquals(3, soln.update(3, 0));
        assertEquals(3, soln.update(1, 1));
        assertEquals(1, soln.update(1, 1));
        assertEquals(1, soln.update(1, 10));
        assertEquals(1, soln.update(2, 6));
        assertEquals(1, soln.update(4, 1));
        assertEquals(1, soln.update(4, 2));
        assertEquals(2, soln.update(4, 8));
    }

    @org.junit.Test
    public void update3() {
        GCPCSolution soln = new GCPCSolution(5);
        assertEquals(2, soln.update(2, 1));
        assertEquals(2, soln.update(1, 3));
        assertEquals(2, soln.update(3, 3));
        assertEquals(2, soln.update(4, 3));
        assertEquals(3, soln.update(3, 4));
        assertEquals(2, soln.update(1, 5));
        assertEquals(2, soln.update(5, 1));
        assertEquals(2, soln.update(5, 7));
        assertEquals(3, soln.update(4, 1));
        assertEquals(1, soln.update(1, 10));
    }

    @org.junit.Test
    public void update4() {
        GCPCSolution soln = new GCPCSolution(6);
        assertEquals(2, soln.update(2, 3));
        assertEquals(3, soln.update(3, 3));
        assertEquals(4, soln.update(4, 3));
        assertEquals(5, soln.update(5, 3));
        assertEquals(6, soln.update(6, 3));
        assertEquals(1, soln.update(1, 1));
    }

    @org.junit.Test
    public void update5() {
        GCPCSolution soln = new GCPCSolution(10000);
        assertEquals(2, soln.update(9876, 111));
        assertEquals(3, soln.update(2, 1));
        assertEquals(4, soln.update(3, 4));
        assertEquals(5, soln.update(4, 3));
        assertEquals(4, soln.update(1, 5));
        assertEquals(4, soln.update(2, 5));
        assertEquals(2, soln.update(1, 6));
        assertEquals(2, soln.update(2, 9));
        assertEquals(3, soln.update(3, 3));
        assertEquals(3, soln.update(9876, 532));
        assertEquals(3, soln.update(9268, 532));
        assertEquals(3, soln.update(1367, 532));
        assertEquals(3, soln.update(2661, 532));
        assertEquals(4, soln.update(9876, 1));
        assertEquals(2, soln.update(1, 123));
        assertEquals(2, soln.update(13, 532));
        assertEquals(2, soln.update(76, 532));
        assertEquals(2, soln.update(10000, 532));
        assertEquals(2, soln.update(9999, 532));
        assertEquals(2, soln.update(2, 131));
        assertEquals(2, soln.update(1, 532));
        assertEquals(1, soln.update(1, 532));
        assertEquals(1, soln.update(3535, 532));
        assertEquals(1, soln.update(3535, 532));
        assertEquals(1, soln.update(3535, 532));
        assertEquals(1, soln.update(3535, 532));
        assertEquals(1, soln.update(3535, 532));
        assertEquals(2, soln.update(3535, 532));
        assertEquals(2, soln.update(3535, 532));
        assertEquals(2, soln.update(3234, 532));
        assertEquals(2, soln.update(135, 532));
        assertEquals(2, soln.update(8888, 532));
        assertEquals(2, soln.update(2347, 532));
        assertEquals(2, soln.update(7373, 532));
        assertEquals(2, soln.update(14, 532));
        assertEquals(2, soln.update(5266, 532));
        assertEquals(2, soln.update(7835, 532));
        assertEquals(2, soln.update(7373, 532));
        assertEquals(2, soln.update(7373, 532));
        assertEquals(2, soln.update(7373, 532));
        assertEquals(2, soln.update(733, 532));
        assertEquals(2, soln.update(263, 532));
        assertEquals(2, soln.update(847, 532));
    }

    @org.junit.Test
    public void update6() {
        GCPCSolution soln = new GCPCSolution(3);
        assertEquals(1, soln.update(1, 5));
        assertEquals(2, soln.update(2, 0));
        assertEquals(2, soln.update(3, 7));
        assertEquals(2, soln.update(2, 3));
        assertEquals(2, soln.update(1, 1));
    }

    @org.junit.Test
    public void update7() {
        GCPCSolution soln = new GCPCSolution(3);
        assertEquals(1, soln.update(1, 5));
        assertEquals(2, soln.update(2, 0));
        assertEquals(2, soln.update(3, 7));
        assertEquals(2, soln.update(2, 7));
        assertEquals(1, soln.update(1, 1));
    }

    @org.junit.Test
    public void update8() {
        GCPCSolution soln = new GCPCSolution(4);
        assertEquals(2, soln.update(2, 6));
        assertEquals(2, soln.update(1, 8));
        assertEquals(3, soln.update(3, 4));
        assertEquals(4, soln.update(4, 2));
        assertEquals(4, soln.update(3, 10));
        assertEquals(4, soln.update(4, 10));
        assertEquals(1, soln.update(1, 4));
    }

    @org.junit.Test
    public void update9() {
        GCPCSolution soln = new GCPCSolution(3);
        assertEquals(2, soln.update(2, 3));
        assertEquals(2, soln.update(2, 1));
        assertEquals(3, soln.update(3, 2));
        assertEquals(3, soln.update(3, 1));
        assertEquals(3, soln.update(1, 1));
        assertEquals(1, soln.update(1, 2));
    }
}
