package Calc;

public class BinaryOperationCommand implements CalcCommand {
	private final CalculatorFacade facade;
	private final String symbol;
	private final float op1;
	private final float op2;
	private Float lastResult;

	public BinaryOperationCommand(CalculatorFacade facade,
	                             String symbol,
	                             float op1,
	                             float op2) {
		this.facade = facade;
		this.symbol = symbol;
		this.op1 = op1;
		this.op2 = op2;
	}

	@Override
	public void execute() {
		lastResult = facade.calculate(symbol, op1, op2);
		System.out.println("[Command] Executed operation: " + op1 + " " + symbol + " " + op2 +
			" = " + lastResult);
	}

	@Override
	public void undo() {
		System.out.println("Undoing operation: " + op1 + " " + symbol + " " + op2 +
			(lastResult != null ? " = " + lastResult : ""));
	}

	public Float getLastResult() {
		return lastResult;
	}
}
