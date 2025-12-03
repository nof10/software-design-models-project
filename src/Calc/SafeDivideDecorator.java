package Calc;
public class SafeDivideDecorator extends OperationDecorator {
    private final float defaultValue;

    public SafeDivideDecorator(Operation wrapped, float defaultValue) {
        super(wrapped);
        this.defaultValue = defaultValue;
    }

    @Override
    public float execute(float operand1, float operand2) {
        if (wrapped instanceof Divide && operand2 == 0f) {
            throw new ArithmeticException("Division by zero (safe decorator)");
        }
        return super.execute(operand1, operand2);
    }
}
