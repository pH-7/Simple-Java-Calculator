package simplejavacalculator.creational;

public interface Operation {
    Double execute(Double... numbers);
    String getDescription();
}