package FactoryPattern;

/*
Factory Pattern

Factory objects is responsible to recognize based on parameters in method what subclass should be returned.
https://www.javatpoint.com/factory-method-design-pattern
 */


public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();

        ProductAbstract product;

        int productIndex = 2;

        product = factory.makeProduct(productIndex);
        System.out.println("Product type: " + product.getName());

        product = factory.makeProduct(3);
        System.out.println("Product type: " + product.getName());


    }
}

abstract class ProductAbstract{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void methodFromAbstract(){
        System.out.println("Method from product abstract");
    }
}

class FirstProductImp extends ProductAbstract{
    public FirstProductImp() {
        setName("First product object");
    }
}

class SecondProductImp extends ProductAbstract{
    public SecondProductImp() {
        setName("Second product object");
    }
}

class SecondProductImpModelB extends SecondProductImp{
    public SecondProductImpModelB() {
        setName("Second product model B object");
    }
}

class Factory{
    public ProductAbstract makeProduct(int index){

        if(index==1){
            return new FirstProductImp();
        } else if (index == 2){
            return new SecondProductImp();
        } else if (index == 3){
            return new SecondProductImpModelB();
        } else return null;


    }
}
