package CommandPattern;

/*
Command Pattern

Add functionality to an object as an another object.

http://www.newthinktank.com/2012/09/command-design-pattern-tutorial/

Typically the Command pattern is used to make an object out of what needs to be done -- to take an operation and its
arguments and wrap them up in an object to be logged, held for undo, sent to a remote site, etc.
There will tend to be a large number of distinct Command objects that pass through a given point in a system over time,
and the Command objects will hold varying parameters describing the operation requested.

The Strategy pattern, on the other hand, is used to specify how something should be done, and plugs into a larger
object or method to provide a specific algorithm. A Strategy for sorting might be a merge sort, might be an insertion
sort, or perhaps something more complex like only using merge sort if the list is larger than some minimum size.
Strategy objects are rarely subjected to the sort of mass shuffling about that Command objects are, instead often being
used for configuration or tuning purposes.

Both patterns involve factoring the code and possibly parameters for individual operations out of the original class that
contained them into another object to provide for independent variability. The differences are in the use cases
encountered in practice and the intent behind each pattern.
https://stackoverflow.com/questions/4834979/difference-between-strategy-pattern-and-command-pattern
 */

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        DeviceImp device = new DeviceImp();
        Command action1Command = new Action1(device);
        Command action2Command = new Action2(device);
        Command action3Command = new Action3(device);

        ActionInvoker action1Invoker = new ActionInvoker(action1Command);
        ActionInvoker action2Invoker = new ActionInvoker(action2Command);
        ActionInvoker action3Invoker = new ActionInvoker(action3Command);

        action1Invoker.executeCommand();
        action1Invoker.undoCommand();
        action1Invoker.executeCommand();
        action2Invoker.executeCommand();
        action3Invoker.executeCommand();
        device.undoAll();
    }
}


interface Command{
    void execute();
    void undo();
}

interface Device{
    LinkedList<Command> commandOrder = new LinkedList();

    LinkedList<Command> getCommandOrder();
    void action1();
    void action2();
    void action3();
}

class DeviceImp implements Device{
    public LinkedList<Command> commandOrder = new LinkedList();
    int value;

    @Override
    public LinkedList<Command> getCommandOrder() {
        return commandOrder;
    }

    @Override
    public void action1() {
        value = 1;
        System.out.println("Action 1. Value = " + value);
    }

    @Override
    public void action2() {
        value = 0;
        System.out.println("Action 2. Undo action 1. Value = " + value );
    }

    @Override
    public void action3() {
        value = 2;
        System.out.println("Action 3. Value = " + value);
    }

    public void undoAll(){
        commandOrder.stream().forEach(command -> command.undo());
    }
}

class Action1 implements Command{
    Device device;

    public Action1(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.getCommandOrder().addFirst(this);
        device.action1();
    }

    @Override
    public void undo() {
        device.action2();
    }
}



class Action2 implements Command{
    Device device;

    public Action2(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.getCommandOrder().addFirst(this);
        device.action2();
    }

    @Override
    public void undo() {
        device.action1();
    }
}


class Action3 implements Command{
    Device device;

    public Action3(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.getCommandOrder().addFirst(this);
        device.action3();
    }

    @Override
    public void undo() {
        System.out.println("Can't undo.");
    }
}

class ActionInvoker{
    Command theCommand;

    public ActionInvoker(Command theCommand) {
        this.theCommand = theCommand;
    }

    public void executeCommand(){
        theCommand.execute();
    }

    public void undoCommand(){
        theCommand.undo();
    }
}














