package heap;

import java.util.stream.IntStream;

public class Heap {
    private int[] elements = new int[1];
    private int capacity;
    
    public Heap() { }
    
    public Heap(int[] arr) {
        this.elements = arr;
        this.capacity = arr.length;
        heapify(capacity-1);
    }

    public void insert(int item) {
        ensureCapacity();
        elements[capacity++] = item;
        heapify((capacity - 2)/2);
    }

    private void heapify(int parent) {
        if (parent >= 0) {
            int left = 2 * parent + 1;
            int right = left + 1;
            int largest = parent;
            
            if (left < capacity && elements[left] > elements[largest])
                largest = left;
            
            if (right < capacity && elements[right] > elements[largest])
                largest = right;
            
            swap(parent, largest);
            if (parent != 0)
                heapify(parent/2);
        }
    }

    private void swap(int index, int parent) {
        int temp = elements[index];
        elements[index] = elements[parent];
        elements[parent] = temp;
    }

    private void ensureCapacity() {
        if (capacity == elements.length) {
            resize();
        }
    }

    private void resize() {
        int[] temp = elements;
        elements = new int[elements.length * 2];
        for (int i = 0;  i < temp.length; i++) {
            elements[i] = temp[i];
        }
    }

    public int size() {
        return capacity;
    }

    public int peek() {
        if (capacity == 0) throw new UnsupportedOperationException("Heap is empty !!");
        return elements[0];
    }
    
    public void prettyPrint() {
        int size = capacity;
        int h = 0;
        while (size >= 1) {
            size >>= 1;
            h++;
        }
        h = h - 1;
        
        String oldOffset = "";
        for (int i = 0; i <= h; i++) {
            int o = (int) Math.pow(2, h - i) - 1;
            int e = (int) Math.pow(2, i) - 1;
            String newOffset = IntStream.range(0, o).mapToObj(x -> " ").reduce(String::concat).orElse("");
            System.out.print(newOffset);
            for (int j = 0; j < (int) Math.pow(2, i); j++) {
                if (e + j >= capacity)
                    break;
                System.out.print(elements[e + j] + oldOffset);
            }
            System.out.println();
            oldOffset = newOffset;
        }
        System.out.println("-------------------------");
    }
}
