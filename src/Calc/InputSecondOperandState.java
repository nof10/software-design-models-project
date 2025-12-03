package Calc;

public class InputSecondOperandState implements CalculatorState {

	@Override
	public void doAction(CalculatorContext context) {
		System.out.println("Calculator is in input-second-operand state");
		context.setState(this);
	}

	@Override
	public String toString() {
		return "InputSecondOperandState";
	}
}
