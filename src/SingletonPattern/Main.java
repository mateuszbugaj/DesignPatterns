package SingletonPattern;


/*
Singleton Pattern

Only one instance of object made with singleton pattern can be created. Constructor of that object is private
and only accessible by it's static method that also checks if instance of this object was already created.
It holds a static field of itself.

 */

public class Main {
    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance(); // creation of the first instance
        singleton.singletonMethod(); // show index in first instance
        singleton.incrementIndex(); // increment index in first instance
        singleton.singletonMethod(); // show index in first instance


        Singleton singletonTwo = Singleton.getInstance(); // creation of the second instance
        singletonTwo.incrementIndex(); // increment index in the second instance
        singletonTwo.singletonMethod(); // show index in the second instance
        // index in the second instance if incremented two times which means it is the same instance every time.
        // Thus, it's one object.


    }
}



class Singleton{
    private static Singleton firstInstance = null;

    int index = 0;

    private Singleton(){}

    public static Singleton getInstance(){
        if(firstInstance == null){
            firstInstance = new Singleton();
        }

        return firstInstance;
    }

    public void incrementIndex(){
        index++;
    }

    public void singletonMethod(){
        System.out.println("From singleton index: " + index);
    }
}
