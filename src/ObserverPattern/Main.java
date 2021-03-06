package ObserverPattern;

import java.util.ArrayList;


/*
Observer Pattern

Change of state of variable in object is monitored by other objects by passing to them reference of the object
possessing monitored value which is also responsible for notifying monitoring objects about change and new value.

https://www.javatpoint.com/observer-pattern
https://youtu.be/wiQdrH2YpT4
 */

public class Main {
    public static void main(String[] args) {
        ObservableImp observable = new ObservableImp();
        ObserverImp observerOne = new ObserverImp(observable);
        observable.setValue(10);

        observerOne.tellValue();

        ObserverImp observerTwo = new ObserverImp(observable);
        observable.setValue(12);

        observerOne.tellValue();
        observerTwo.tellValue();

    }
}



interface Observable {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}

interface Observer{
    void update(int value);
    int getId();
}

class ObservableImp implements Observable {

    private ArrayList<Observer> observers = new ArrayList<>(); // list of observers (reference to observers)
    int value; // monitored value


    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer observerToDelete) {
        int observerIndex = observers.indexOf(observerToDelete);
        System.out.println("Observer with ID: " + observerIndex + " deleted.");
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Notifying observers...");
        for(Observer observer:observers){
            observer.update(value);
            System.out.println("Observer nr." + observer.getId() + " notified.");
        }
    }

    public void setValue(int value) {
        System.out.print("Value changed from " + this.value);
        this.value = value;
        System.out.println(" to " + this.value);

        notifyObservers();
    }



}


class ObserverImp implements Observer{
    private int value;

    private static int observerIdTracker = 0;
    private int observerId;

    private Observable subjectImp;

    public ObserverImp(Observable subjectImp) {
        this.subjectImp = subjectImp;

        observerId = ++observerIdTracker;

        System.out.println("New observer: " + observerId);
        subjectImp.register(this);

    }

    @Override
    public void update(int value) {
        this.value = value;
        System.out.println("Value updated: " + value + " in observer nr." + observerId);
    }

    @Override
    public int getId() {
        return observerId;
    }

    public void tellValue(){
        System.out.println("Value coming from observer " + observerId + " equal to " + value);
    }
}
























