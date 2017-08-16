package designPatterns;

interface ICommand
{
	void Do();        
}

class MyUndoCommand implements ICommand
{
	private Receiver receiver;
	MyUndoCommand(Receiver recv)
	{
		receiver=recv;
	}
	@Override 
	public void Do()
	{
		//Call undo in receiver
		receiver.performUndo();
	}		     
}
class MyRedoCommand implements ICommand
{
	private Receiver receiver;
	MyRedoCommand(Receiver recv)
	{
	 receiver=recv;
	}
	@Override 
	public void Do()
	{
		//Call redo in receiver
		receiver.performRedo();
	}
}
class DoACommand implements ICommand {
	private Receiver2 rec2;

	public DoACommand(Receiver2 rec2) {
		this.rec2 = rec2;
	}

	@Override
	public void Do() {
		rec2.doA();
	}
}
class DoBCommand implements ICommand {
	private Receiver2 rec2;

	public DoBCommand(Receiver2 rec2) {
		this.rec2 = rec2;
	}

	@Override
	public void Do() {
		rec2.doB();
	}
}
//Receiver class
class Receiver
{
	public void performUndo()
	{
		System.out.println("Executing -MyUndoCommand");
	}
	public void performRedo()
	{
		System.out.println("Executing -MyRedoCommand");
	}
}

class Receiver2
{
	public void doA()
	{
		System.out.println("Doing A");
	}
	public void doB()
	{
		System.out.println("Doing B");
	}
}
//Invoker Class
class Invoke
{   
	ICommand cmd;     
	public void ExecuteCommand(ICommand cmd)
	{
		this.cmd=cmd;
		cmd.Do();
	}
}
//Client here
class CommandPatternEx 
{
	public static void main(String[] args)
	{
		test3();
	}

	private static void test1() {
		System.out.println("***Command Pattern Demo***\n");
		Receiver intendedreceiver=new Receiver();
		//Client holds Invoker and Command Objects
		Invoke inv = new Invoke();
		MyUndoCommand unCmd = new MyUndoCommand(intendedreceiver);
		MyRedoCommand reCmd = new MyRedoCommand(intendedreceiver);
		inv.ExecuteCommand(unCmd);
		inv.ExecuteCommand(reCmd);
	}

	private static void test2() {
		Receiver receiver = new Receiver();

		ICommand undoCommand = new MyUndoCommand(receiver);
		ICommand redoCommand = new MyRedoCommand(receiver);

		Invoke invoke = new Invoke();
		invoke.ExecuteCommand(undoCommand);
		invoke.ExecuteCommand(redoCommand);
	}

	private static void test3() {
		Receiver2 receiver2 = new Receiver2();

		ICommand do1Command = new DoACommand(receiver2);
		ICommand do2Command = new DoBCommand(receiver2);

		Invoke invoke = new Invoke();
		invoke.ExecuteCommand(do1Command);
		invoke.ExecuteCommand(do2Command);
	}

}

