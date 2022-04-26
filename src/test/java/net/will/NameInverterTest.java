package net.will;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <h3>Video Book: Clean Code Fundamentals</h3>
 * <p>Robert C. Martin</p>
 *
 * <p>Advanced Test-Driven Development (TDD), Part 1</p>
 */
public class NameInverterTest {
    private NameInverter nameInverter;

    @BeforeEach
    public void setup() {
        nameInverter = new NameInverter();
    }

    private void assertInverted(String originalName, String invertedName) {
        assertEquals(invertedName, nameInverter.invertName(originalName));
    }

    @Test
    public void givenNull_returnsEmptyString() {
        assertInverted(null, "");
    }

    @Test
    public void givenEmptyString_returnsEmptyString() {
        assertInverted("", "");
    }

    @Test
    public void givenSimpleName_returnsSimpleName() {
        assertInverted("Name", "Name");
    }

    @Test
    public void givenASimpleNameWithSpaces_returnsSimpleNameWithoutSpaces() {
        assertInverted(" Name ", "Name");
    }

    @Test
    public void givenFirstLast_returnsLastFirst() {
        assertInverted("First Last", "Last, First");
    }

    @Test
    public void givenFirstLastWithExtraSpaces_returnsLastFirst() {
        assertInverted("  First  Last   ", "Last, First");
    }

    @Test
    public void ignoreHonorific() {
        assertInverted("Mr. First Last", "Last, First");
        assertInverted("Mrs. First Last", "Last, First");
    }

    @Test
    public void postNominal_stayAtEnd() {
        assertInverted("First Last Sr.", "Last, First Sr.");
        assertInverted("First Last BS. Phd.", "Last, First BS. Phd.");
    }

    @Test
    public void integration() {
        assertInverted("  First    Last   III esq.   ", "Last, First III esq.");
    }
}
