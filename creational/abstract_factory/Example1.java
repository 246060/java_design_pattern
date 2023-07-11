package creational.abstract_factory;

interface Product {
    void operation();
}

interface ProductA extends Product {
    void operationA();
}

interface ProductB extends Product {
    void operationB();
}

class ConcreteProductA implements ProductA {

    @Override
    public void operation() {
        System.out.println("ConcreteProductA의 operation 메소드");
    }

    @Override
    public void operationA() {
        System.out.println("ConcreteProductA의 operationA 메소드");
    }
}

class ConcreteProductB implements ProductB {
    @Override
    public void operation() {
        System.out.println("ConcreteProductB의 operation 메소드");
    }

    @Override
    public void operationB() {
        System.out.println("ConcreteProductB의 operationB 메소드");
    }
}

interface AbstractFactory {
    ProductA createProductA();

    ProductB createProductB();
}

class ConcreteFactory implements AbstractFactory {

    @Override
    public ProductA createProductA() {
        return new ConcreteProductA();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB();
    }

}

public class Example1 {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory();
        ProductA productA = factory.createProductA();
        productA.operation();
        productA.operationA();

        ProductB productB = factory.createProductB();
        productB.operation();
        productB.operationB();
    }
}
