public class TestHeap {
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>();
        for (int i = 1; i < 10;i++)
            heap.add(i);
        heap.printArray();
        heap.add(0);
        heap.printArray();
    }
}
