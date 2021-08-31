public class TestSLL {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> mySLL = new SinglyLinkedList<>();
        mySLL.addToFront(3);
        mySLL.addToFront(2);
        mySLL.addToFront(1);
        printSLL(mySLL);
        mySLL.addToBack(4);
        printSLL(mySLL);
    }

    // Print SLL
    public static <E> void printSLL(SinglyLinkedList<E> mySLL){
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