public class TestHeap {
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>();
        //System.out.println(heap.size());
        heap.add(0);
        heap.add(1);
        heap.add(2);
        heap.add(4);
        heap.add(3);
        heap.add(5);
        heap.add(7);
        heap.add(6);
        heap.add(8);
        heap.add(9);
        heap.add(10);
        heap.add(11);
        heap.add(12);

        heap.printArray();
        heap.remove();
        heap.printArray();
        heap.remove();
        heap.printArray();
    }
}
