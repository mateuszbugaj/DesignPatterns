package PrototypePattern;

/*
Prototype Pattern

Creates clone and not the reference to the objects.
Object that implements Prototype interface that extends Cloneable is able to return a clone of
itself via method which will pass it's data in that time to a clone. Change made in clone will not
affect data in the original.

http://www.newthinktank.com/2012/09/prototype-design-pattern-tutorial/
 */


public class Main {
    public static void main(String[] args) {

        Object object = new Object();

        System.out.println("Object value is equal: " + object.getValue());

        object.setValue(7);
        Object clonedObject = (Object) object.getClone();

        System.out.println("Cloned object value is equal: " + clonedObject.getValue());

        object.setValue(11);
        System.out.println("Object value is equal: " + object.getValue());
        System.out.println("Cloned object value is equal: " + clonedObject.getValue());


    }

}

interface Prototype extends Cloneable{
    Prototype getClone();
}

class Object implements Prototype{
    private int value;

    public Object() {
        System.out.println("Object is made.");
    }

    @Override
    public Prototype getClone() {
        System.out.println("Clone is made.");

        Object object = null;

        try {
            object = (Object) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return object;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


