package testen;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domein.LogicParts;

class ComputerPartsTest {

    private LogicParts computerPart = new LogicParts();

    @Test
    void addTest() {
        assertEquals(20, computerPart.add(10, 10));
        assertEquals(182, computerPart.add(27, 155));
        assertEquals(123, computerPart.add(55, 68));
    }

    @Test
    void subtractionTest() {
        assertEquals(0, computerPart.subtract(10, 10));
        assertEquals(-95, computerPart.subtract(27, 122));
        assertEquals(-13, computerPart.subtract(55, 68));
    }

    @Test
    void andGateTest() {
        assertEquals(255, computerPart.andGate(255, 255));
        assertEquals(128, computerPart.andGate(195, 128));
        assertEquals(27, computerPart.andGate(223, 59));
        assertEquals(0, computerPart.andGate(0, 255));
    }

    @Test
    void orGateTest() {
        assertEquals(255, computerPart.orGate(15, 240));
        assertEquals(253, computerPart.orGate(192, 253));
        assertEquals(255, computerPart.orGate(255, 85));
    }

    @Test
    void notGateTest() {
        assertEquals(216, computerPart.notGate(39));
        assertEquals(242, computerPart.notGate(13));
        assertEquals(44, computerPart.notGate(211));
        assertEquals(255, computerPart.notGate(0));
        assertEquals(0, computerPart.notGate(255));
        assertEquals(127, computerPart.notGate(128));
        assertEquals(128, computerPart.notGate(127));
    }

    @Test
    void xorGateTest() {
        assertEquals(240, computerPart.xorGate(255, 15));
        assertEquals(93, computerPart.xorGate(192, 157));
        assertEquals(170, computerPart.xorGate(255, 85));
    }

    @Test
    void rightShiftTest() {
        assertEquals(0, computerPart.rightShift(255, 8));
        assertEquals(1, computerPart.rightShift(255, 7));
        assertEquals(21, computerPart.rightShift(175, 3));
        assertEquals(96, computerPart.rightShift(192, 1));
        assertEquals(0, computerPart.rightShift(255, 9));
        assertEquals(0, computerPart.rightShift(1, 1));
    }

    @Test
    public void testAddInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> computerPart.add(-1, 10));
        assertThrows(IllegalArgumentException.class, () -> computerPart.add(10, 256));
    }

    @Test
    public void testSubtractInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> computerPart.subtract(-333, 10));
        assertThrows(IllegalArgumentException.class, () -> computerPart.subtract(10, 256));
    }

    @Test
    public void testAndGateInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> computerPart.andGate(-1, 10));
        assertThrows(IllegalArgumentException.class, () -> computerPart.andGate(10, 256));
    }

    @Test
    public void testOrGateInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> computerPart.orGate(-1, 10));
        assertThrows(IllegalArgumentException.class, () -> computerPart.orGate(10, 256));
    }

    @Test
    public void testXorGateInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> computerPart.xorGate(-1, 10));
        assertThrows(IllegalArgumentException.class, () -> computerPart.xorGate(10, 256));
    }

    @Test
    public void testNotGateInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> computerPart.notGate(-1));
        assertThrows(IllegalArgumentException.class, () -> computerPart.notGate(256));
    }

    @Test
    public void testRightShiftInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> computerPart.rightShift(1, -3));
        assertThrows(IllegalArgumentException.class, () -> computerPart.rightShift(256, 4));
    }
}
