package Behavioral.templateMethod;

abstract class AbstractClass {
    public void templateMethod() {
        step1();
        step2();
        step3();
    }

    abstract void step1();

    abstract void step2();

    void step3() {
        System.out.println("템플릿 메소드의 기본 구현 - step3");
    }
}

class ConcreteClass extends AbstractClass {

    @Override
    void step1() {
        System.out.println("구체적인 템플릿의 구현 - step1");
    }

    @Override
    void step2() {
        System.out.println("구체적인 템플릿의 구현 - step2");
    }

}

public class Example1 {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }
}
