package Calc;
public class LoggingOperationDecorator extends OperationDecorator {

    public LoggingOperationDecorator(Operation wrapped) {
        super(wrapped);
    }

    @Override
    public float execute(float operand1, float operand2) {
        float result = super.execute(operand1, operand2);
        String symbol = "?";
        Operation base = wrapped;
        while (base instanceof OperationDecorator) {
            base = ((OperationDecorator) base).wrapped;
        }
        if (base instanceof Add) symbol = "+";
        else if (base instanceof Subtract) symbol = "-";
        else if (base instanceof Multiply) symbol = "×";
        else if (base instanceof Divide) symbol = "÷";

        System.out.println(String.format("[LOG] %s %s %s = %s", operand1, symbol, operand2, result));
        return result;
    }
}

