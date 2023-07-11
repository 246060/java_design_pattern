package creational.singleton;

//  일반적인 싱글톤 패턴
class SingletonA {
    private static SingletonA instance;

    private SingletonA() {
    }

    public static SingletonA getInstance() {
        if (instance == null) {
            instance = new SingletonA();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Singleton 인스턴스의 기능을 수행합니다.");
    }
}

// 스레드 안전한 싱글톤 패턴
class SingletonB {
    private static SingletonB instance;

    private SingletonB() {
    }

    public static synchronized SingletonB getInstance() {
        if (instance == null) {
            instance = new SingletonB();
        }
        return instance;
    }
}

// DCL(Double-Checked Locking)을 사용한 스레드 안전한 싱글톤 패턴
class SingletonC {
    private static volatile SingletonC instance;

    private SingletonC() {
    }

    public static SingletonC getInstance() {
        if (instance == null) {
            synchronized (SingletonC.class) {
                if (instance == null) {
                    instance = new SingletonC();
                }
            }
        }
        return instance;
    }
}

// 초기화된 인스턴스 방식 (Eager Initialization):
class SingletonD {
    private static SingletonD instance = new SingletonD();

    private SingletonD() {
    }

    public static SingletonD getInstance() {
        return instance;
    }
}

// enum을 이용한 방식
enum SingletonE {
    INSTANCE;

    public void doSomething() {
        System.out.println("SingletonE 인스턴스의 기능을 수행합니다.");
    }
}

public class Example1 {
    public static void main(String[] args) {
        SingletonA singleton1 = SingletonA.getInstance();
        SingletonA singleton2 = SingletonA.getInstance();

        System.out.println(singleton1 == singleton2);

        singleton1.doSomething();
        singleton2.doSomething();
    }
}
