package Week5.Generics;

public class SimplyLinkedList<T> {
    Node head;

    public void insert(T value) {
        // Case 1, no elements added yet
        if (head == null) {
            head = new Node(value);
        }
        else {
            Node lastNode = head;

            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }

            lastNode.next = new Node(value);
        }
    }

    public void printFromFront(){
        Node nodeToPrint = head;
        while(nodeToPrint != null){
            System.out.println(nodeToPrint.value);
            nodeToPrint = nodeToPrint.next;
        }
    }

}

class Node<T>{
    T value;
    Node next;

    public Node(T value){
        this.value = value;
    }
}
