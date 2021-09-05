import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     * <p>
     * This must be done recursively.
     * <p>
     * The new data should become a leaf in the tree.
     * <p>
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     * <p>
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null)
            throw new IllegalArgumentException();
        // Call wrapper method
        root = innerAdd(data, root);
        size++;
    }

    private BSTNode<T> innerAdd(T data, BSTNode<T> currNode) {
        // Create new node if null
        if (currNode == null) {
            currNode = new BSTNode<T>(data);
            System.out.println(currNode.getData());
        }
        // Recurse left if currNode > data
        if (currNode.getData().compareTo(data) > 0)
            currNode.setLeft(innerAdd(data, currNode.getLeft()));
            // Recurse right if currNode < data
        else if (currNode.getData().compareTo(data) < 0)
            currNode.setRight(innerAdd(data, currNode.getRight()));
        return currNode;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     * <p>
     * This must be done recursively.
     * <p>
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     * <p>
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     * <p>
     * Hint: Should you use value equality or reference equality?
     * <p>
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // Except Catch #1
        if (data == null) {
            throw new IllegalArgumentException();
        }
        BSTNode<T> dummy = new BSTNode<T>(null);
        root = innerRemove(data, root, dummy);
        return dummy.getData();
    }

    private BSTNode<T> innerRemove(T data, BSTNode<T> currData, BSTNode<T> dummy) {
        // if Not found
        if (currData == null)
            throw new NoSuchElementException();
        // Find data
        if (currData.getData().compareTo(data) < 0) {
            System.out.println("Right: " + currData.getData() + " , Date = " + data);
            currData.setRight(innerRemove(data, currData.getRight(), dummy));
            return currData;
        } else if (currData.getData().compareTo(data) > 0) {
            System.out.println("Left: " + currData.getData() + " , Date = " + data);
            currData.setLeft(innerRemove(data, currData.getLeft(), dummy));
            return currData;
        }
        // Data found
        else {
            System.out.println("Data found");
            // Set dummy
            dummy.setData(currData.getData());
            size--;
            // 0 Children Case
            if (currData.getLeft() == null && currData.getRight() == null){
                System.out.println("Case 0");
                return null;
            }
            // 1 Child Case
            else if (currData.getLeft() != null && currData.getRight() == null){
                System.out.println("Case L");
                return currData.getLeft();
            }
            else if (currData.getRight() != null && currData.getLeft() == null){
                System.out.println("Case R");
                return currData.getRight();
            }
            // 2 Child Case
            else{
                System.out.println("Case 2");
                // 2nd dummy for successor
                BSTNode<T> dummy2 = new BSTNode<>(null);
                currData.setRight(removeSuccessor(currData.getRight(),dummy2));
                System.out.println("Successor = " + dummy2.getData());
                currData.setData(dummy2.getData());
                return currData;
            }
        }
    }
    private BSTNode<T> removeSuccessor(BSTNode<T> currData, BSTNode<T> dummy2){
        if (currData.getLeft() == null){
            dummy2.setData(currData.getData());
            return currData.getRight();
        }
        else {
           currData.setLeft(removeSuccessor(currData.getLeft(),dummy2));
           return currData;
        }
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
    public List<T> preorder(BSTNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> returnVals = new ArrayList<T>();
        if (root == null){
            return returnVals;
        }
        if (baseCase(root) == true){
            returnVals.add(root.getData());
        }
        else {
            List<T> leftVals = preorder(root.getLeft());
            List<T> rightVals = preorder(root.getRight());
            returnVals.add(root.getData());
            returnVals.addAll(leftVals);
            returnVals.addAll(rightVals);
        }
        return returnVals;
    }
    private boolean baseCase(BSTNode<T> root){
        if (root.getLeft() == null && root.getRight() == null)
            return true;
        return false;
    }
}