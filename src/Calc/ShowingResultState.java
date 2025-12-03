package Calc;

public class ShowingResultState implements CalculatorState {

	@Override
	public void doAction(CalculatorContext context) {
		System.out.println("Calculator is in showing-result state");
		context.setState(this);
	}

	@Override
	public String toString() {
		return "ShowingResultState";
	}
}
