package Calc;

public class CommandInvoker {
	public void placeOrder(CalcCommand command) {
		command.execute();
	}
	public void undoOrder(CalcCommand command) {
		command.undo();
	}
}
