package Calc;
public class RoundingOperationDecorator extends OperationDecorator {
    private final int decimals;

    public RoundingOperationDecorator(Operation wrapped, int decimals) {
        super(wrapped);
        this.decimals = Math.max(0, decimals);
    }

    @Override
    public float execute(float operand1, float operand2) {
        float result = super.execute(operand1, operand2);
        double scale = Math.pow(10, decimals);
        double rounded = Math.round(result * scale) / scale;
        return (float) rounded;
    }
}
