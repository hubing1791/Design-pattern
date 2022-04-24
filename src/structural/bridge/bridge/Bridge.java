package structural.bridge.bridge;

public class Bridge {
    public static void main(String[] args) {
        Message message = new EmailMessage();
        UragencyMessage uragencyMessage = new UragencyMessage(message);
        uragencyMessage.sendMessage("你好","自己");
    }
}

//实现角色
interface Message {

    void send(String message, String toUser);
}


//下面两个是具体实现
class EmailMessage implements Message {

    @Override
    public void send(String message, String toUser) {
        System.out.println(String.format("使用邮件短信息的方法，发送信息[%s]给[%s]", message, toUser));
    }

}

class SmsMessage implements Message {

    @Override
    public void send(String message, String toUser) {
        System.out.println(String.format("使用短信服务的方法，发送信息[%s]给[%s]", message, toUser));
    }

}



//抽象角色
abstract class AbstractMessage {
    Message message;

    public AbstractMessage(Message message) {
        this.message = message;
    }

    public void sendMessage(String message, String toUser) {
        this.message.send(message, toUser);
    }
}


//抽象实现
class NomalMessage extends AbstractMessage{
    public NomalMessage(Message message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        super.sendMessage(message, toUser);
    }
}

class UragencyMessage extends AbstractMessage {

    public UragencyMessage(Message message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "紧急消息：" + message;
        super.sendMessage(message, toUser);
    }

}

