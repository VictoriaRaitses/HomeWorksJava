package telran.consumer.operation;

import telran.consumer.IStringOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseOperationTest {

    IStringOperation operation = new ReverseOperation();

    @Test
    public void testOperate_emptyString_emptyString() {
        assertEquals("", operation.operate(""));
    }

    @Test
    public void testOperate_StringABC_reverse() {
        assertEquals("CBA", operation.operate("ABC"));
    }

    @Test
    public void testOperate_mixedStringWithSymbols_reverse() {
        assertEquals("D;#Ds*dSa", operation.operate("aSd*sD#;D"));
    }
}