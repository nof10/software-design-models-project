package Calc;

public class CalculatorContext {

	private CalculatorState state;

	public CalculatorContext() {
		this.state = null;
	}

	public void setState(CalculatorState state) {
		this.state = state;
	}

	public CalculatorState getState() {
		return state;
	}
}
