package DecoratorPattern;

/*
Decorator Pattern / Wrapper

Uses composition instead of inheritance to extend the functionality of and object dynamically.


 */


public class Main {
    public static void main(String[] args) {

        Object object = new PartOne(new PartThree(new PartTwo(new PartOne(new DefaultObject()))));
        System.out.println(object.getNamesOfParts());
        System.out.println(object.getValue());

    }
}

interface Object {
    String getNamesOfParts();
    int getValue();
}

class DefaultObject implements Object{

    @Override
    public String getNamesOfParts() {
        return "Base";
    }

    @Override
    public int getValue() {
        return 10;
    }
}

class ObjectDecorator implements Object{

    protected Object tempObject;

    public ObjectDecorator(Object tempObject) {
        this.tempObject = tempObject;
    }

    @Override
    public String getNamesOfParts() {
        return tempObject.getNamesOfParts();
    }

    @Override
    public int getValue() {
        return tempObject.getValue();
    }
}

class PartOne extends ObjectDecorator{

    public PartOne(Object tempObject) {
        super(tempObject);
    }

    @Override
    public String getNamesOfParts() {
        return tempObject.getNamesOfParts() + ", part one";
    }

    @Override
    public int getValue() {
        return tempObject.getValue() + 1;
    }

}

class PartTwo extends ObjectDecorator{

    public PartTwo(Object tempObject) {
        super(tempObject);
    }

    @Override
    public String getNamesOfParts() {
        return tempObject.getNamesOfParts() + ", part two";
    }

    @Override
    public int getValue() {
        return tempObject.getValue() + 1;
    }

}

class PartThree extends ObjectDecorator{

    public PartThree(Object tempObject) {
        super(tempObject);
    }

    @Override
    public String getNamesOfParts() {
        return tempObject.getNamesOfParts() + ", part three";
    }

    @Override
    public int getValue() {
        return tempObject.getValue() + 1;
    }

}














