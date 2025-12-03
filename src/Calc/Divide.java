package Calc;

public class Divide implements Operation {
    @Override
    public float execute(float operand1, float operand2) {
        if (operand2 == 0) throw new ArithmeticException("Division by zero");
        return operand1 / operand2;
    }
}
