package structural.adapter;

interface Target {
    void request();
}

class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee의 특정 요청 메소드");
    }
}

class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("Adapter의 request() 메소드");
        adaptee.specificRequest();
    }
}

public class Example1 {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);

        adapter.request();
    }
}
