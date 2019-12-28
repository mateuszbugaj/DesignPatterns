package AdapterPattern;

/*
Adapter Pattern

Gives the ability to use object with different interface than it's original implemented interface.
 */


public class Main {
    public static void main(String[] args) {
        Object object = new Object();
        object.methodOneA();

        InterfaceA interfaceA = new Object();
        interfaceA.methodOneA();

        InterfaceB interfaceB = new ObjectInterfaceBAdapter(object);
        interfaceB.methodOneB();
    }
}


interface InterfaceA{
    void methodOneA();
    void methodTwoA();
    void methodOThreeA();
}


interface InterfaceB{
    void methodOneB();
    void methodTwoB();
    void methodOThreeB();
}

class Object implements InterfaceA{

    @Override
    public void methodOneA() {
        System.out.println("method One A");
    }

    @Override
    public void methodTwoA() {
        System.out.println("method Two A");
    }

    @Override
    public void methodOThreeA() {
        System.out.println("method Three A");
    }
}

class ObjectInterfaceBAdapter implements InterfaceB{

    InterfaceA objectInterfaceA ;

    public ObjectInterfaceBAdapter(InterfaceA objectInterfaceA) {
        this.objectInterfaceA = objectInterfaceA;
    }

    @Override
    public void methodOneB() {
        objectInterfaceA.methodOneA();
    }

    @Override
    public void methodTwoB() {
        objectInterfaceA.methodTwoA();
    }

    @Override
    public void methodOThreeB() {
        objectInterfaceA.methodOThreeA();
    }
}
