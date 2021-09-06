import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // Check for null data
        if (data == null)
            throw new IllegalArgumentException();
        // Resize
        if (backingArray.length == size){
            T[] temp = (T[]) new Comparable[backingArray.length*2];
            for (int i = 1;i < backingArray.length;i++){
                temp[i] = backingArray[i];
            }
            backingArray = temp;
        }

        // Add new data & increment size
        backingArray[size+1] = data;
        size++;

        // DownHeap - Recursive
        upHeap(size);
    }

    private void upHeap(int index){
        // Base Case - Top Node
        if (index / 2 == 0){
            return;
        }
        if (backingArray[index].compareTo(backingArray[index/2]) < 0){
            T temp = backingArray[index/2];
            backingArray[index/2] = backingArray[index];
            backingArray[index] = temp;
        }
        upHeap(index/2);
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // Case - No data
        if (size == 0)
            throw new NoSuchElementException();

        // Perform swap
            // Save removed value to return
        T result = backingArray[1];
            // Swap final element to begin
        backingArray[1] = backingArray[size];
            // Set swapped element to null & decrement size
        backingArray[size] = null;
        size--;

        // DownHeap
        downHeap(1);

        // Return result
        return result;
    }

    private void downHeap(int index){
        // Base Case - Leaf node
        if (index > size / 2)
            return;

        // Make comparison and swap
        int compIndex = index*2;
            // Decide which child is smaller and compare
        if (backingArray[index*2+1] != null && backingArray[index*2].compareTo(backingArray[index*2+1]) > 0){
            compIndex+=1;
        }
            // Compare to child & swap if less than child
        if (backingArray[index].compareTo(backingArray[compIndex]) > 0){
            T temp = backingArray[index];
            backingArray[index] = backingArray[compIndex];
            backingArray[compIndex] = temp;
        }

        // Recurse down
        downHeap(compIndex);
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
    public void printArray(){
        System.out.print("Array: [");
        for (int i = 1; i < size+1;i++) {
            System.out.print(backingArray[i]);
            if (i != size)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}