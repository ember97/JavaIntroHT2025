package Week5.Generics;
/*
1 Skriv en generisk klass med namnet Safe, som representerar ett kassaskåp.
Klassen ska ha metoderna store och retrieve.
Store ska kunna lägga till ett objekt i kassaskåpet.
Retrieve ska ta bort och returnera ett objekt som tidigare lagras i kassaskåpet.
 */
public class Safe<T>{
    T object;

    public void store(T obj){
        object = obj;
    }

    public T retrieve(){
        T tmp = object;
        object = null;
        return tmp;
    }
}
