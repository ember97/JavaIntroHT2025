package Week4;

public abstract class Animal {
    public void eat(){
        System.out.println("Generic animal eats");
    }
    public void move(){
        System.out.println("Generic animal moves");
    }

    public void play(){
        System.out.println("Having fun!");
    }
}

class LandBasedThings extends Animal {
    public void eat(){
        System.out.println("Landsbased animal eats");
    }
    public void move(){
        System.out.println("Landbased animal moves");
    }
}

class WaterBasedThings extends Animal {
    public void eat(){
        System.out.println("Waterbased animal eats");
    }
    public void move(){
        System.out.println("Waterbased animal moves");
    }
}

class Dog extends LandBasedThings {
    public void eat(){
        super.eat(); // Kallar på eat() i LandBasedThings
        System.out.println("Dog eats");
    }
    public void move(){
        System.out.println("Dog is running");
    }

    @Override
    public void play() {
        System.out.println("Dog plays");
    }
}

class Dolphine extends WaterBasedThings {
    public void eat(){
        System.out.println("Dolphine eats");
    }
    public void move(){
        System.out.println("Dolphine swims");
    }
}
