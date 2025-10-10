package Week5.Generics;

import java.util.ArrayList;
import java.util.List;

public class Stack<T>{
    List<T> list = new ArrayList<>();

    public void push(T element){
        list.add(element);
    }

    public T pop(){
        T element = list.removeLast();
        return element;
    }
}
