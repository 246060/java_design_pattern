package structural.facade;

class SubSystemA {
    public void operationA() {
        System.out.println("SubSystemA의 operationA 메소드");
    }
}

class SubSystemB {
    public void operationB() {
        System.out.println("SubSystemB의 operationB 메소드");
    }
}

class SubSystemC {
    public void operationC() {
        System.out.println("SubSystemC의 operationC 메소드");
    }
}

class Facade {
    private SubSystemA subSystemA;
    private SubSystemB subSystemB;
    private SubSystemC subSystemC;

    public Facade() {
        subSystemA = new SubSystemA();
        subSystemB = new SubSystemB();
        subSystemC = new SubSystemC();
    }

    public void operation() {
        System.out.println("Facade의 operation 메소드");
        subSystemA.operationA();
        subSystemB.operationB();
        subSystemC.operationC();
    }
}

public class Example1 {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.operation();
    }
}
