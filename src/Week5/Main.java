package Week5;

import Week5.Generics.Stack;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        /*Boat boat = new Boat();
        Bicycle bicycle = new Bicycle();
        Sailboat sailBoat = new Sailboat();
        Trio<Boat, Bicycle, Sailboat> trio = new Trio(boat,bicycle,sailBoat);
        System.out.println("x: " + trio.x);
         */
    }





}
