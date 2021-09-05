import java.util.List;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> myBST = new BST<>();
        myBST.add(50);
        myBST.add(15);
        myBST.add(75);
        myBST.add(5);
        myBST.add(100);
        myBST.add(10);
        myBST.add(60);
        myBST.add(90);
        myBST.add(110);
        myBST.add(80);
        myBST.add(95);

        List<Integer> myResult = myBST.preorder(myBST.getRoot());
        for (int val : myResult){
            System.out.print(val + " ");
        }
        System.out.println();

        // Remove 75
        System.out.println("Removed : " + myBST.remove(50));
        myResult = myBST.preorder(myBST.getRoot());
        for (int val : myResult){
            System.out.print(val + " ");
        }
        System.out.println();

    }
}
