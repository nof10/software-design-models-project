package Calc;
public abstract class OperationDecorator implements Operation {
    protected final Operation wrapped;

    public OperationDecorator(Operation wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public float execute(float operand1, float operand2) {
        return wrapped.execute(operand1, operand2);
    }
}


