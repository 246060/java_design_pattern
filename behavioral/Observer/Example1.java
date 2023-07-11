package Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

interface Subject {
    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);

    void notifyObservers();
}

class ConcreteObserver1 implements Observer {
    @Override
    public void update(String message) {
        System.out.println("구독자 1: " + message);
    }
}

class ConcreteObserver2 implements Observer {
    @Override
    public void update(String message) {
        System.out.println("구독자 2: " + message);
    }
}

class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList();
    private String message;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }
}

public class Example1 {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        subject.setMessage("Hi");

        subject.unregisterObserver(observer2);

        subject.setMessage("Hello");
    }
}
