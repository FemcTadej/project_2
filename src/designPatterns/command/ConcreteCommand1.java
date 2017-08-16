package designPatterns.command;

/**
 * Created by Hugiell on 16. 08. 2017.
 */
public class ConcreteCommand1 implements Command {
    private Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action1();
    }

}
