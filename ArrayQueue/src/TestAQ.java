public class TestAQ {
    public static void main(String[] args) {
        ArrayQueue<Integer> myAQ = new ArrayQueue<>();
        myAQ.enqueue(1);
        myAQ.enqueue(2);
        myAQ.enqueue(3);
        myAQ.enqueue(4);
        myAQ.enqueue(5);
        myAQ.enqueue(6);
        myAQ.enqueue(7);
        myAQ.enqueue(8);
        myAQ.enqueue(9);
        //myAQ.enqueue(10);
        myAQ.printBA();
        System.out.println(myAQ.dequeue());
        myAQ.printBA();
        myAQ.enqueue(10);
        myAQ.printBA();
    }
}
