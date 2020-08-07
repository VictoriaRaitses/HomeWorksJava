package telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LcmTest {
    Lcm lcm = new Lcm();

    @Test
    public void testLcm_1and1_1() {
        assertEquals(1, lcm.lcm(1, 1));
    }

    @Test
    public void testLcm_1and1and1_1() {
        assertEquals(1, lcm.lcm(1, 1, 1));
    }

    @Test
    public void testLcm_1and14_14() {
        assertEquals(14, lcm.lcm(1, 14));
        assertEquals(14, lcm.lcm(14, 1));

    }

    @Test
    public void testLcm_1and14and14_14() {
        assertEquals(14, lcm.lcm(1, 14, 14));
        assertEquals(14, lcm.lcm(14, 14, 1));

    }

    @Test
    public void testLcm_1and17_17() {
        assertEquals(17, lcm.lcm(1, 17));
        assertEquals(17, lcm.lcm(17, 1));

    }

    @Test
    public void testLcm_1and17and17_17() {
        assertEquals(17, lcm.lcm(1, 17, 17));
        assertEquals(17, lcm.lcm(17, 17, 1));

    }

    @Test
    public void testLcm_6and9_3() {
        assertEquals(18, lcm.lcm(6, 9));
        assertEquals(18, lcm.lcm(9, 6));
    }

    @Test
    public void testLcm_6and9and17_306() {
        assertEquals(306, lcm.lcm(6, 9, 17));
        assertEquals(306, lcm.lcm(17, 9, 6));
    }

    @Test
    public void testLcm_72and35_2520() {
        assertEquals(2520, lcm.lcm(72, 35));
        assertEquals(2520, lcm.lcm(35, 72));

    }

    @Test
    public void testLcm_72and35and89_224280() {
        assertEquals(224280, lcm.lcm(72, 35, 89));
        assertEquals(224280, lcm.lcm(89, 35, 72));
    }
}