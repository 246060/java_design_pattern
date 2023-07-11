package creational.factory;

interface Product {
    void operation();
}

class ConcreteProduct implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProduct의 operation 메소드");
    }
}

interface Factory {
    Product createProduct();
}

class ConcreteFactory implements Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProduct();
    }
}

public class Example1 {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactory();
        Product product = factory.createProduct();
        product.operation();
    }
}
