package BridgePattern;

/*
Bridge Pattern

Two levels of abstraction. It decouples functional abstraction from the implementation so that the two can vary independently.

https://www.javatpoint.com/bridge-pattern
 */


public class Main {
    public static void main(String[] args) {

        Abstraction abstraction = new RefinedAbstractionA(new ConcreteImplementor(8));
        Abstraction abstraction1 = new RefinedAbstractionB(new ConcreteImplementor(17));

        abstraction.methodOne();
        abstraction.methodTwo();
        abstraction.methodThree();
        abstraction.methodFour();

        abstraction1.methodFour();

    }

}

abstract class Implementor{
    public int value;

    public abstract void methodOne();
    public abstract void methodTwo();
    public void methodThree(){
        System.out.println("From method three: " + value);
    }
}

class ConcreteImplementor extends Implementor{

    public ConcreteImplementor(int newValue) {
        value = newValue;
    }

    @Override
    public void methodOne() {
        value++;
        System.out.println("Value up. Now: " + value);
    }

    @Override
    public void methodTwo() {
        value--;
        System.out.println("Value down. Now: " + value);
    }
}

abstract class Abstraction{
    private ConcreteImplementor concreteImplementor;

    public Abstraction(ConcreteImplementor concreteImplementor) {
        this.concreteImplementor = concreteImplementor;
    }

    public void methodOne(){
        concreteImplementor.methodOne();
    }

    public void methodTwo(){
        concreteImplementor.methodTwo();
    }

    public void methodThree(){
        concreteImplementor.methodThree();
    }

    public abstract void methodFour();
}


class RefinedAbstractionA extends Abstraction{


    public RefinedAbstractionA(ConcreteImplementor concreteImplementor) {
        super(concreteImplementor);
    }

    @Override
    public void methodFour() {
        System.out.println("Method four A.");
    }
}


class RefinedAbstractionB extends Abstraction{


    public RefinedAbstractionB(ConcreteImplementor concreteImplementor) {
        super(concreteImplementor);
    }

    @Override
    public void methodFour() {
        System.out.println("Method four B.");
    }
}


































