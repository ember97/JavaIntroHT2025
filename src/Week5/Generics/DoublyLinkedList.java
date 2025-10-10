package Week5.Generics;

public class DoublyLinkedList<T> {
    DoubleNode head;

    public void insert(DoubleNode node) {
        // Case 1, no elements added yet
        if (head == null) {
            head = node;
        }
        else {
            DoubleNode lastNode = head;

            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }

            node.previous = lastNode; // lastNode is before the element we want to insert
            lastNode.next = node; // nextNode is after lastNode
        }
    }

    public void printFromFront(){
        DoubleNode nodeToPrint = head;
        while(nodeToPrint != null){
            System.out.println(nodeToPrint.value);
            nodeToPrint = nodeToPrint.next;
        }
    }

    public void printFromBack(DoubleNode start){
        DoubleNode nodeToPrint = start;
        while(nodeToPrint != null){
            System.out.println(nodeToPrint.value);
            nodeToPrint = nodeToPrint.previous;
        }
    }

}

