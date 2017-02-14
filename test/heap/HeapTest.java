package heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeapTest {

    private Heap heap;
    
    @Before
    public void setUp() { heap = new Heap(); }
    
    @Test
    public void testInsertOneItem() {
        heap.insert(1);
        heap.prettyPrint();
        Assert.assertEquals(1, heap.size());
    }
    
    @Test
    public void testInsertTwoItems() {
        heap.insert(1);
        heap.insert(2);
        heap.prettyPrint();
        Assert.assertEquals(2, heap.size());
        Assert.assertEquals(2, heap.peek());
    }
    
    @Test
    public void testInsertThreeItems() {
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.prettyPrint();
        Assert.assertEquals(3, heap.size());
        Assert.assertEquals(3, heap.peek());
    }
    
    @Test
    public void testInitWithArrayAndPrettyPrint() {
        int[] arr = new int[] {1, 1, 2, 1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 7, 8};
        Heap heap1 = new Heap(arr);
        heap1.prettyPrint();
    }
}
