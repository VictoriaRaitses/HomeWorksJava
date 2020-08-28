package telran.operation;

import telran.consumer.IStringOperation;

public class UpperCase implements IStringOperation {
    private static final String NAME = "upper_case";

    @Override
    public String operate(String line) {
        return line.toUpperCase();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
