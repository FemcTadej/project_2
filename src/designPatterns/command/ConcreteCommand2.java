package designPatterns.command;

/**
 * Created by Hugiell on 16. 08. 2017.
 */
public class ConcreteCommand2 implements Command {
    private Receiver receiver;

    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action2();
    }
}
