package structural.proxy;

interface Subject {
    void request();
}

class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject의 request 메소드");
    }
}

class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {

        if (realSubject == null) {
            realSubject = new RealSubject();
        }

        // 접근 제어나 부가적인 작업 수행
        System.out.println("프락시가 작업을 수행하기 전에 추가적인 동작을 수행합니다.");

        realSubject.request();

        // 부가적인 작업 수행
        System.out.println("프락시가 작업을 수행한 후에 추가적인 동작을 수행합니다.");
    }

}

public class Example1 {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
