package telran.consumer;

import telran.consumer.operation.LowerCaseOperation;
import org.junit.jupiter.api.Test;
import telran.consumer.operation.ReverseOperation;
import telran.consumer.operation.UpperCaseOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class OperationStorageTest {
    OperationStorage storage = new OperationStorage();

    @Test
    public void testInit_putEmptyList_emptyStorage() throws ClassNotFoundException {
        storage.init(new ArrayList<>());
        assertEquals(0, storage.operationByName.size());
    }

    @Test
    public void testInit_oneExistingOperation_filledStorage() throws ClassNotFoundException {
        storage.init(Collections.singletonList("telran.consumer.operation.LowerCaseOperation"));
        assertEquals(1, storage.operationByName.size());

        IStringOperation operation = storage.operationByName.get("lower_case");
        assertTrue(operation instanceof LowerCaseOperation);
    }

    @Test
    public void testInit_threeExistingOperation_filledStorage() throws ClassNotFoundException {
        storage.init(Arrays.asList("telran.consumer.operation.UpperCaseOperation", "telran.consumer.operation.ReverseOperation", "telran.consumer.operation.LowerCaseOperation"));
        assertEquals(3, storage.operationByName.size());

        IStringOperation operationLowerCase = storage.operationByName.get("lower_case");
        assertTrue(operationLowerCase instanceof LowerCaseOperation);

        IStringOperation operationUpperCase = storage.operationByName.get("upper_case");
        assertTrue(operationUpperCase instanceof UpperCaseOperation);

        IStringOperation operationReverse = storage.operationByName.get("reverse");
        assertTrue(operationReverse instanceof ReverseOperation);
    }

}