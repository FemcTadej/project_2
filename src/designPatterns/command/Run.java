package designPatterns.command;

/**
 * Created by Hugiell on 16. 08. 2017.
 */
public class Run {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();

        Command command1 = new ConcreteCommand1(receiver);
        Command command2 = new ConcreteCommand2(receiver);

        Invoker invoker = new Invoker();
        invoker.invoke(command1);
        invoker.invoke(command2);
    }

}
