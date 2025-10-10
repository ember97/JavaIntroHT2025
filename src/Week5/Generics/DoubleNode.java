package Week5.Generics;

public class DoubleNode<T> {
    T value;
    DoubleNode next;
    DoubleNode previous;

    public DoubleNode(T value) {
        this.value = value;
    }
}
