package designPatterns.command;

/**
 * Created by Hugiell on 16. 08. 2017.
 */
public class Invoker {

    public void invoke(Command command) {
        command.execute();
    }

}
