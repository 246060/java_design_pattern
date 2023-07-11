package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

interface Flyweight {
    void operation();
}

class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation() {
        System.out.println("Intrinsic State: " + intrinsicState);
    }
}

class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        if (flyweights.containsKey(key)) {
            return flyweights.get(key);
        } else {
            Flyweight flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
            return flyweight;
        }
    }
}

public class Example1 {
    public static void main(String[] args) {

        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweight1 = factory.getFlyweight("key1");
        flyweight1.operation();

        Flyweight flyweight2 = factory.getFlyweight("key2");
        flyweight2.operation();

        Flyweight flyweight3 = factory.getFlyweight("key3");
        flyweight3.operation();
    }
}
