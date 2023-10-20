package net.proselyte.basepatterns.behavioral.chain2;

public class Main {
    public static void main(String[] args) {
        MessageHandler messageHandler = new MessageAddExcLamationMarkHandler(
                new MessageVerifyHandler(
                        new MessagePrintHandler(null)));
        messageHandler.handle("hello");
    }
}

abstract class MessageHandler {
    MessageHandler messageHandler;
    public MessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }
    abstract void handle(String msg);
}

class MessagePrintHandler extends MessageHandler {
    public MessagePrintHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }
public
    @Override
    void handle(String msg) {
        System.out.println(msg + 1);
    }
}
class MessageVerifyHandler extends MessageHandler {
    public MessageVerifyHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }
    public
    @Override
    void handle(String msg) {
        messageHandler.handle(msg + 2);

    }
}

class MessageAddExcLamationMarkHandler extends MessageHandler {
    public MessageAddExcLamationMarkHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }
    public
    @Override
    void handle(String msg) {
        messageHandler.handle(msg + 3);
    }
}
