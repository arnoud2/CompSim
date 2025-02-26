package testen;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import domein.CompareParts;

public class ComparePartsTest {

	private CompareParts compareParts = new CompareParts();

	@Test
	public void testEqualTrue() {
		assertTrue(compareParts.equal(100, 100));
		assertTrue(compareParts.equal(255, 255));
		assertTrue(compareParts.equal(0, 0));
		assertTrue(compareParts.equal(123, 123));
	}

	@Test
	public void testEqualFalse() {
		assertFalse(compareParts.equal(100, 200));
		assertFalse(compareParts.equal(0, 255));
		assertFalse(compareParts.equal(250, 123));
		assertFalse(compareParts.equal(10, 20));
	}

	@Test
	public void testNotEqualTrue() {
		assertTrue(compareParts.notEqual(100, 200));
		assertTrue(compareParts.notEqual(0, 255));
		assertTrue(compareParts.notEqual(123, 250));
		assertTrue(compareParts.notEqual(10, 20));
	}

	@Test
	public void testNotEqualFalse() {
		assertFalse(compareParts.notEqual(100, 100));
		assertFalse(compareParts.notEqual(255, 255));
		assertFalse(compareParts.notEqual(0, 0));
		assertFalse(compareParts.notEqual(123, 123));
	}

	@Test
	public void testLessOrEqualTrue() {
		assertTrue(compareParts.lessOrEqual(100, 200));
		assertTrue(compareParts.lessOrEqual(100, 100));
		assertTrue(compareParts.lessOrEqual(0, 255));
		assertTrue(compareParts.lessOrEqual(10, 100));
	}

	@Test
	public void testLessOrEqualFalse() {
		assertFalse(compareParts.lessOrEqual(200, 100));
		assertFalse(compareParts.lessOrEqual(255, 100));
		assertFalse(compareParts.lessOrEqual(100, 99));
		assertFalse(compareParts.lessOrEqual(150, 100));
	}

	@Test
	public void testGreaterThanTrue() {
		assertTrue(compareParts.greaterThan(200, 100));
		assertTrue(compareParts.greaterThan(255, 0));
		assertTrue(compareParts.greaterThan(150, 100));
		assertTrue(compareParts.greaterThan(250, 100));
	}

	@Test
	public void testGreaterThanFalse() {
		assertFalse(compareParts.greaterThan(100, 200));
		assertFalse(compareParts.greaterThan(50, 100));
		assertFalse(compareParts.greaterThan(0, 255));
		assertFalse(compareParts.greaterThan(0, 0));
	}

	@Test
	public void testGreaterOrEqualTrue() {
		assertTrue(compareParts.greaterOrEqual(200, 100));
		assertTrue(compareParts.greaterOrEqual(100, 100));
		assertTrue(compareParts.greaterOrEqual(255, 255));
		assertTrue(compareParts.greaterOrEqual(150, 100));
	}

	@Test
	public void testGreaterOrEqualFalse() {
		assertFalse(compareParts.greaterOrEqual(100, 200));
		assertFalse(compareParts.greaterOrEqual(99, 100));
		assertFalse(compareParts.greaterOrEqual(0, 255));
		assertFalse(compareParts.greaterOrEqual(50, 100));
	}

	@Test
	public void testLessThanTrue() {
		assertTrue(compareParts.lessThan(100, 200));
		assertTrue(compareParts.lessThan(0, 255));
		assertTrue(compareParts.lessThan(50, 100));
		assertTrue(compareParts.lessThan(10, 100));
	}

	@Test
	public void testLessThanFalse() {
		assertFalse(compareParts.lessThan(200, 100));
		assertFalse(compareParts.lessThan(255, 0));
		assertFalse(compareParts.lessThan(100, 50));
		assertFalse(compareParts.lessThan(100, 100));
	}

	@Test
	public void testInvalidInput() {
		assertThrows(IllegalArgumentException.class, () -> compareParts.equal(300, 100));
		assertThrows(IllegalArgumentException.class, () -> compareParts.equal(-1, 100));
		assertThrows(IllegalArgumentException.class, () -> compareParts.notEqual(300, 200));
		assertThrows(IllegalArgumentException.class, () -> compareParts.lessOrEqual(100, 300));
		assertThrows(IllegalArgumentException.class, () -> compareParts.greaterThan(100, 256));
		assertThrows(IllegalArgumentException.class, () -> compareParts.greaterOrEqual(-1, 0));
		assertThrows(IllegalArgumentException.class, () -> compareParts.lessThan(300, 200));
	}
}
