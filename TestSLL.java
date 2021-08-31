public class TestSLL {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> mySLL = new SinglyLinkedList<>();
        //System.out.println(mySLL.getTail()); Passed 2 tests
        //System.out.println(mySLL.getHead());
        mySLL.addToFront(3);
        //System.out.println(mySLL.getHead().getNext()); Passed 2 tests
        //System.out.println(mySLL.getTail().getNext());
        mySLL.addToFront(2);
        mySLL.addToFront(1);
        printSLL(mySLL);
        mySLL.addToBack(4);
        printSLL(mySLL);
        //System.out.println(mySLL.removeFromFront());
        //System.out.println(mySLL.removeFromFront());
        System.out.println(mySLL.removeFromBack());
        System.out.println(mySLL.removeFromBack());
        System.out.println(mySLL.removeFromBack());
        System.out.println(mySLL.removeFromBack());
        printSLL(mySLL);
    }

    // Print SLL
    public static <E> void printSLL(SinglyLinkedList<E> mySLL){
        if (mySLL.getHead() == null) {
            System.out.println("Empty");
            return;
        }
        SinglyLinkedListNode<E> currNode = mySLL.getHead();
        String myString = "";
        int count = 0;
        while (currNode.getData() != null){
            if (count != 0)
                myString += " --> ";
            myString += String.valueOf(currNode.getData());
            if (currNode.getNext() == null)
                break;
            currNode = currNode.getNext();
            count++;
        }
        System.out.println(myString);
    }
}
