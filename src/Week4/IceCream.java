package Week4;

// Fråga 8
public abstract class IceCream {
    public void buy(int price){
        System.out.println("This ice cream cost " + price);
    }

    public abstract void picture();
}

class Piggelin extends IceCream{
    @Override
    public void buy(int price){
        System.out.println("A piggelin costs " + price);
    }

    @Override
    public void picture(){
        System.out.println("(|||)--");
    }
}
