package Behavioral.strategy;

interface Strategy {
    void execute();
}

class ConcreteStrategy1 implements Strategy {
    @Override
    public void execute() {
        System.out.println("strategy 1");
    }
}

class ConcreteStrategy2 implements Strategy {
    @Override
    public void execute() {
        System.out.println("strategy 2");
    }
}

class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }
}

public class Example1 {
    public static void main(String[] args) {
        Context context = new Context();

        context.setStrategy(new ConcreteStrategy1());
        context.executeStrategy();

        context.setStrategy(new ConcreteStrategy2());
        context.executeStrategy();
    }
}
