package Calc;

public final class OperationFactory {
    private OperationFactory() {
        
    }

    public static Operation createOperation(String symbol) {
        if (symbol == null) return null;
        switch (symbol) {
            case "+":
                return new Add();
            case "-":
                return new Subtract();
            case "×":
                return new Multiply();
            case "÷":
                return new Divide();
            default:
                return null;
        }
    }
}
