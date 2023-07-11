package structural.bridge;

abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}

interface Implementor {
    void operationImpl();
}

class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        System.out.println("RefinedAbstraction의 operation 메소드");
        implementor.operationImpl();
    }
}

class ConcreteImplementor implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementor의 operationImpl 메소드");
    }
}

public class Example1 {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementor();
        Abstraction abstraction = new RefinedAbstraction(implementor);

        abstraction.operation();
    }
}
