package behavioral.command.command;

import java.util.ArrayList;
import java.util.List;

//借鉴了这个例子 https://blog.csdn.net/weixin_40980639/article/details/123218117
public class CommandTest {
        public static void main(String[] args) {
        Command command = new OpenCommand();
        Command changeCommand = new ChangeCommand();
        Command closeCommand = new CloseCommand();
        ArrayList<Command> list = new ArrayList<>();
        list.add(command);
        list.add(changeCommand);
        list.add(closeCommand);
        Control control = new Control(list);
        control.action();
    }
}



//抽象命令类
interface Command {

    void execute();
}

//具体命令类 ，开电视
class OpenCommand implements Command{
    private TV tv = new TV();

    @Override
    public void execute() {
        tv.open();
    }
}

//具体命令类 ，换台
class ChangeCommand implements Command{
    private TV tv = new TV();

    @Override
    public void execute() {
        tv.change();
    }
}


 //具体命令类 ，关电视
class CloseCommand implements Command{
    private TV tv = new TV();
    @Override
    public void execute() {
        tv.close();
    }
}

//调用者，遥控器
class Control {

    public List<Command> commands = new ArrayList<>();

    public Control(Command command) {
        commands.add(command);
    }

    public Control(List<Command> commands) {
        this.commands.addAll(commands);
    }

    public void action() {
        commands.forEach(Command::execute);
    }
}

//接收者：电视
class TV {
    public void open() {
        System.out.println("打开电视机");
    }
    public void change() {
        System.out.println("切换电视机");
    }
    public void close() {
        System.out.println("关闭电视机");
    }
}