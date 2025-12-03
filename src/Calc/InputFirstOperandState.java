package Calc;

public class InputFirstOperandState implements CalculatorState {

	@Override
	public void doAction(CalculatorContext context) {
		System.out.println("Calculator is in input-first-operand state");
		context.setState(this);
	}

	@Override
	public String toString() {
		return "InputFirstOperandState";
	}
}
