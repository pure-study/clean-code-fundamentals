package net.will;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameInverterTest {
    private void assertInverted(String originalName, String invertedName) {
        assertEquals(invertedName, invertName(originalName));
    }

    @Test
    public void givenNull_returnsEmptyString() {
        assertInverted(null, "");
    }

    @Test
    public void givenEmptyString_returnsEmptyString() {
        assertInverted("", "");
    }

    private String invertName(String name) {
        return "";
    }
}
