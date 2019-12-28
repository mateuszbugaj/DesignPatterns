package FacadePattern;

/*
Facade Pattern

Describes higher level interface that makes lower lever subsystem easier to use.

https://www.javatpoint.com/facade-pattern
 */




public class Main {
    public static void main(String[] args) {

        Object object = new Object();

        object.InterfaceImpOneUsage();
        object.InterfaceImpTwoUsage();

    }
}

interface Interface{
    void methodOne();
    void methodTwo();
}

class InterfaceImpOne implements Interface{

    @Override
    public void methodOne() {
        System.out.println("Imp One Method One");
    }

    @Override
    public void methodTwo() {
        System.out.println("Imp One Method Two");
    }
}


class InterfaceImpTwo implements Interface{

    @Override
    public void methodOne() {
        System.out.println("Imp Two Method One");
    }

    @Override
    public void methodTwo() {
        System.out.println("Imp Two Method Two");
    }
}

class Object{
    private Interface interfaceImpOne;
    private Interface interfaceImpTwo;


    public Object() {
        interfaceImpOne = new InterfaceImpTwo();
        interfaceImpTwo = new InterfaceImpTwo();
    }

    public void InterfaceImpOneUsage(){
        interfaceImpOne.methodOne();
        interfaceImpOne.methodTwo();
    }

    public void InterfaceImpTwoUsage(){
        interfaceImpTwo.methodOne();
        interfaceImpTwo.methodTwo();
    }

}












