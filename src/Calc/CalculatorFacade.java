package Calc;

import java.util.List;

public class CalculatorFacade {
    private CalculatorEngine engine;

    public CalculatorFacade() {
        this.engine = CalculatorEngine.getInstance();
    }
    public float calculate(String symbol, float op1, float op2) {
        return calculate(symbol, op1, op2, false, false, 0);
    }
    public float calculateWithLogging(String symbol, float op1, float op2) {
        return calculate(symbol, op1, op2, true, false, 0);
    }
    public float calculate(String symbol, float op1, float op2, boolean logging, boolean rounding, int decimals) {
        Operation op = OperationFactory.createOperation(symbol);
        if (op == null) throw new IllegalArgumentException("Unknown operation symbol: " + symbol);

        if (rounding) {
            op = new RoundingOperationDecorator(op, decimals);
        }

        if (logging) {
            op = new LoggingOperationDecorator(op);
        }

        return engine.evaluate(op, op1, op2);
    }

    public List<String> getHistory() {
        return engine.getHistory();
    }

    public void printHistory() {
        engine.printHistory();
    }

    public void clearHistory() {
        engine.clearHistory();
    }
}


