
/*
Builder Pattern

Building device consisting of 3 parts. Parts return string with it's type and model of device.

Device plan says how device should be build.
Abstract class Part says how each part should behave.
Part types say what different should each type do.
Device class is a concrete class based on device plan. It holds fields with parts.
Device builder defines methods needed to create parts for the device.
Device builder for model A creates device object and populates it's fields with actual and right types of
parts and can return this device.
Director takes device builder and makes it do what it can.

http://www.newthinktank.com/2012/09/builder-design-pattern-tutorial/
 */





public class BuilderPattern {
    public static void main(String[] args) {

        DeviceBuilder deviceBuilder = new DeviceBuilderModelA();

        Director director = new Director(deviceBuilder);

        director.makeDevice();

        Device device = director.getDevice();

        System.out.println(device.getPartOne().toString());
        System.out.println(device.getPartTwo().toString());
        System.out.println(device.getPartThree().toString());
    }

}


interface DevicePlan{
    void setPartOne(Part partOne);
    void setPartTwo(Part partTwo);
    void setPartThree(Part partThree);
}

abstract class Part{
    private String model;

    public Part(String model){
        this.model = model;
    }

    public String getModel(){
        return model;
    }

    public abstract String toString();

}

class PartOne extends Part{

    public PartOne(String model) {
        super(model);
    }

    @Override
    public String toString() {
        return "Part one indicator: " + getModel();
    }
}


class PartThree extends Part{

    public PartThree(String model) {
        super(model);
    }

    @Override
    public String toString() {
        return "Part three indicator: " + getModel();
    }
}


class PartTwo extends Part{


    public PartTwo(String model) {
        super(model);
    }

    @Override
    public String toString() {
        return "Part two indicator: " + getModel();
    }
}

class Device implements DevicePlan{

    private Part partOne;
    private Part partTwo;
    private Part partThree;

    public Part getPartOne() {
        return partOne;
    }

    public Part getPartTwo() {
        return partTwo;
    }

    public Part getPartThree() {
        return partThree;
    }

    @Override
    public void setPartOne(Part partOne) {
        this.partOne = partOne;
    }

    @Override
    public void setPartTwo(Part partTwo) {
        this.partTwo = partTwo;
    }

    @Override
    public void setPartThree(Part partThree) {
        this.partThree = partThree;
    }
}

interface DeviceBuilder{
    void buildPartOne();
    void buildPartTwo();
    void buildPartThree();
    Device getDevice();
}

class DeviceBuilderModelA implements DeviceBuilder{

    private Device device;

    public DeviceBuilderModelA() {
        this.device = new Device();
    }

    @Override
    public void buildPartOne() {
        device.setPartOne(new PartOne("Model A"));
    }

    @Override
    public void buildPartTwo() {
        device.setPartTwo(new PartTwo("Model A"));
    }

    @Override
    public void buildPartThree() {
        device.setPartThree(new PartThree("Model A"));
    }

    @Override
    public Device getDevice() {
        return device;
    }


}

class Director{
    private DeviceBuilder deviceBuilder;

    public Director(DeviceBuilder deviceBuilder) {
        this.deviceBuilder = deviceBuilder;
    }

    public Device getDevice() {
        return deviceBuilder.getDevice();
    }

    public void makeDevice(){
        deviceBuilder.buildPartOne();
        deviceBuilder.buildPartTwo();
        deviceBuilder.buildPartThree();
    }
}
