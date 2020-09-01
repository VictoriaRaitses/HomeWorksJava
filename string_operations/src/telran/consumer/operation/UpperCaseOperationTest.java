package telran.consumer.operation;

import telran.consumer.IStringOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpperCaseOperationTest {

    IStringOperation operation = new UpperCaseOperation();

    @Test
    public void testOperate_emptyString_emptyString() {
        assertEquals("", operation.operate(""));
    }

    @Test
    public void testOperate_lowerCaseString_upperCase() {
        assertEquals("ABC", operation.operate("abc"));
    }

    @Test
    public void testOperate_mixedStringWithSymbols_upperCase() {
        assertEquals("ASD*SD#;DFB", operation.operate("aSd*sD#;dfb"));
    }
}