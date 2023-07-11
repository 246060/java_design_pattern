package Behavioral.ChainOfResponsibility;

class Request {
    private String content;

    public Request(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

interface Handler {
    void setNextHandler(Handler nextHandler);

    void handleRequest(Request request);
}

class ConcreteHandler1 implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getContent().contains("처리자 1")) {
            System.out.println("처리자 1 요청 처리");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class ConcreteHandler2 implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getContent().contains("처리자 2")) {
            System.out.println("처리자 2 요청 처리 ");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

public class Example1 {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();

        handler1.setNextHandler(handler2);

        Request request1 = new Request("처리자 1 요청");
        handler1.handleRequest(request1);

        Request request2 = new Request("처리자 2 요청");
        handler1.handleRequest(request2);

        Request request3 = new Request("다른 요청");
        handler1.handleRequest(request3);

    }
}
