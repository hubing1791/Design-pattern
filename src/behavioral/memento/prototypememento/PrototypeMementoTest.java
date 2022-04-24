package behavioral.memento.prototypememento;

public class PrototypeMementoTest {
        public static void main(String[] args) {
        OriginatorPrototype originatorPrototype = new OriginatorPrototype();
        PrototypeCaretaker prototypeCaretaker = new PrototypeCaretaker();
        originatorPrototype.setState("S0");
        System.out.println("初始状态:" + originatorPrototype.getState());
        prototypeCaretaker.setMemento(originatorPrototype.createMemento()); //保存状态
        originatorPrototype.setState("S1");
        System.out.println("新的状态:" + originatorPrototype.getState());
        originatorPrototype.restoreMemento(prototypeCaretaker.getMemento()); //恢复状态
        System.out.println("恢复状态:" + originatorPrototype.getState());
    }

}

//发起人原型
class OriginatorPrototype implements Cloneable {
    private String state;
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public OriginatorPrototype createMemento() {
        return this.clone();
    }
    public void restoreMemento(OriginatorPrototype opt) {
        this.setState(opt.getState());
    }
    public OriginatorPrototype clone() {
        try {
            return (OriginatorPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
//原型管理者
class PrototypeCaretaker {
    private OriginatorPrototype opt;
    public void setMemento(OriginatorPrototype opt) {
        this.opt = opt;
    }
    public OriginatorPrototype getMemento() {
        return opt;
    }
}