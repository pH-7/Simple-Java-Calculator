package simplejavacalculator.structural.adapter;

public class TrigonometricOperation implements ScientificOperation {
    private final String operation;

    public TrigonometricOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public Double computeScientific(Double angle) {
        switch (operation) {
            case "sin":
                return Math.sin(Math.toRadians(angle));
            case "cos":
                return Math.cos(Math.toRadians(angle));
            case "tan":
                if (angle == 0 || angle % 180 == 0) {
                    return 0.0;
                }
                if (angle % 90 == 0.0 && angle % 180 != 0.0) {
                    return Double.NaN;
                }
                return Math.tan(Math.toRadians(angle));
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }
}