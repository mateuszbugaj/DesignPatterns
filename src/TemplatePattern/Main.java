package TemplatePattern;

/*
Template Pattern

Abstract class defines the skeleton of function deferring some aspects to its subclasses.

https://www.javatpoint.com/template-pattern
 */

public class Main {
    public static void main(String[] args) {

        Skeleton subClassA = new SubClassA();

        subClassA.methodThree();

        Skeleton subClassB = new SubClassB();

        subClassB.methodThree();

    }
}

abstract class Skeleton{
    public abstract void methodOne();
    public abstract void methodTwo();
    public final void methodThree() {
        methodOne();
        methodTwo();
    }
}

class SubClassA extends Skeleton{

    @Override
    public void methodOne() {
        System.out.println("Method one A.");
    }

    @Override
    public void methodTwo() {
        System.out.println("Method two A.");
    }
}

class SubClassB extends Skeleton{

    @Override
    public void methodOne() {
        System.out.println("Method one B.");
    }

    @Override
    public void methodTwo() {
        System.out.println("Method two B.");
    }
}