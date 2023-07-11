package Behavioral.visitor;

interface Visitor {
    void visit(ElementA element);

    void visit(ElementB element);
}

interface Element {
    void accept(Visitor visitor);
}

class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ElementA element) {
        System.out.println("ConcreteVisitor가 ElementA를 방문하였습니다.");
        // ElementA에 대한 동작 수행
    }

    @Override
    public void visit(ElementB element) {
        System.out.println("ConcreteVisitor가 ElementB를 방문하였습니다.");
        // ElementB에 대한 동작 수행
    }
}

class ElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // ElementA에 대한 추가 동작 수행
}

class ElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // ElementB에 대한 추가 동작 수행
}

public class Example1 {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();

        Element elementA = new ElementA();
        Element elementB = new ElementB();

        elementA.accept(visitor);
        elementB.accept(visitor);
    }
}
