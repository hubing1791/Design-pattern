package behavioral.strategy;

public class Strategy {
    public static void main(String[] args) {
        Context c = new Context();
        StrategyM strategyM = new ConcreteStrategyA();
        c.setStrategy(strategyM);
        c.strategyMethod();
        System.out.println("-----------------");
        strategyM = new ConcreteStrategyB();
        c.setStrategy(strategyM);
        c.strategyMethod();
    }
}

//抽象策略类
interface StrategyM {
    public void strategyMethod();    //策略方法
}

//具体策略类A
class ConcreteStrategyA implements StrategyM {
    public void strategyMethod() {
        System.out.println("具体策略A的策略方法被访问！");
    }
}
//具体策略类B
class ConcreteStrategyB implements StrategyM {
    public void strategyMethod() {
        System.out.println("具体策略B的策略方法被访问！");
    }
}
//环境类
class Context {
    private StrategyM strategy;
    public StrategyM getStrategy() {
        return strategy;
    }
    public void setStrategy(StrategyM strategy) {
        this.strategy = strategy;
    }
    public void strategyMethod() {
        strategy.strategyMethod();
    }
}