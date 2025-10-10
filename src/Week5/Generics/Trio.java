package Week5.Generics;

import Week4.Vehicle;

public class Trio<T extends Vehicle, S extends Vehicle, R extends Vehicle> {
    public T x;
    public S y;
    public R z;

    public Trio(T x, S y, R z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
