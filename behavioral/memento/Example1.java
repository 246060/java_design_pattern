package Behavioral.memento;

class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento save() {
        return new Memento(state);
    }

    public void restore(Memento memento) {
        state = memento.getState();
    }
}

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Caretaker {
    private Memento memento;

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }
}

public class Example1 {
    public static void main(String[] args) {

        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("상태 1");
        System.out.println("원본 객체의 현재 상태: " + originator.getState());

        caretaker.setMemento(originator.save());

        originator.setState("상태 2");
        System.out.println("원본 객체의 현재 상태: " + originator.getState());

        originator.restore(caretaker.getMemento());
        System.out.println("복원된 원본 객체의 상태: " + originator.getState());
    }
}
