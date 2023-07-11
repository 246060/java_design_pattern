interface State {
    void doAction(Context context);
}

class ConcreteState1 implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("state 1");
        context.setState(new ConcreteState2());
    }
}

class ConcreteState2 implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("state 2");
        context.setState(new ConcreteState1());
    }
}

class Context {
    private State state;

    public Context() {
        state = new ConcreteState1();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void doAction() {
        state.doAction(this);
    }
}

public class Example1 {
    public static void main(String[] args) {
        Context context = new Context();

        context.doAction();
        context.doAction();
    }
}
