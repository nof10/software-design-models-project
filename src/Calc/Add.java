package Calc;

public class Add implements Operation {
    @Override
    public float execute(float operand1, float operand2) {
        return operand1 + operand2;
    }
}
