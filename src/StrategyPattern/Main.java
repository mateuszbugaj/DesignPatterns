package StrategyPattern;

/*
Strategy Pattern

Functionality is obtained by class by external objects that implements  the same interface of that functionality.
This way you eliminate the need for conditional statements and you make it easier to extend and incorporate new behavior.
https://www.javatpoint.com/strategy-pattern
 */

public class Main {

    public static void main(String[] args) {
        Context contextFirst = new Context(new firstFuncImp());
        contextFirst.executeStrategy();

        Context contextSecond = new Context(new SecondFuncImp());
        contextSecond.executeStrategy();
    }

}

interface Strategy{
    void functionality();
}

class firstFuncImp implements Strategy {
    @Override
    public void functionality() {
        System.out.println("Activated first func.");
    }
}

class SecondFuncImp implements Strategy {
    @Override
    public void functionality() {
        System.out.println("Activated second func.");
    }
}

class Context{
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(){
        strategy.functionality();
    }
}

