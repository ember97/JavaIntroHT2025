package Week4;

public abstract class Vehicle {

    public void toGo(String location){
        System.out.println("A vehicle goes to " + location);
    }
}

class Bicycle extends Vehicle{

    @Override
    public void toGo(String location){
        System.out.println("A bicycle goes to " + location);
    }
}

class Car extends Vehicle{

}

class Boat extends Vehicle{

}

class Motorboat extends Boat {

    @Override
    public void toGo(String location) {
        System.out.println("A motorboat goes to " + location);
    }
}

class Sailboat extends Boat {

}


