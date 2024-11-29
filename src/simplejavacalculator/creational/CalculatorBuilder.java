package simplejavacalculator.creational;

public class CalculatorBuilder {
    private Double result = 0.0;
    private final OperationFactory factory;

    public CalculatorBuilder() {
        this.factory = new OperationFactory();
    }

    public CalculatorBuilder withNumber(Double number) {
        this.result = number;
        return this;
    }

    public CalculatorBuilder withOperation(String operationType, Double number) {
        Operation operation = factory.createOperation(operationType);
        this.result = operation.execute(this.result, number);
        return this;
    }

    public Double build() {
        return result;
    }

}
