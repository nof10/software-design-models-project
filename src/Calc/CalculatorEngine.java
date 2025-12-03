package Calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CalculatorEngine {
    private static CalculatorEngine instance;
    private final List<String> history;

    private CalculatorEngine() {
        history = new ArrayList<>();
    }

    public static synchronized CalculatorEngine getInstance() {
        if (instance == null) {
            instance = new CalculatorEngine();
        }
        return instance;
    }

    public float evaluate(Operation operation, float op1, float op2) {
        float result = operation.execute(op1, op2);
        String record = op1 + " " + symbolOf(operation) + " " + op2 + " = " + result;
        history.add(record);
        return result;
    }

    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }

    synchronized void addHistoryRecord(String record) {
        history.add(record);
    }

    public synchronized void clearHistory() {
        history.clear();
    }

    public synchronized void printHistory() {
        if (history.isEmpty()) {
            System.out.println("Calculator history is empty.");
            System.out.flush();
            return;
        }
        System.out.println("Calculator history:");
        for (String record : history) {
            System.out.println(record);
        }
        System.out.flush();
    }

    private String symbolOf(Operation operation) {
        Operation op = operation;
        while (op instanceof OperationDecorator) {
            op = ((OperationDecorator) op).wrapped;
        }
        if (op instanceof Add) return "+";
        if (op instanceof Subtract) return "-";
        if (op instanceof Multiply) return "×";
        if (op instanceof Divide) return "÷";
        return "?";
    }
}
