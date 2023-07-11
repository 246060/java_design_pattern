package creational.prototype;

interface Prototype {
    Prototype clone();

    void operation();
}

class ConcretePrototype implements Prototype {

    @Override
    public void operation() {
        System.out.println("ConcretePrototype의 operation 메소드");
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype();
    }
}

public class Example1 {
    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype();
        Prototype clonedPrototype = prototype.clone();

        prototype.operation();
        clonedPrototype.operation();
    }
}
