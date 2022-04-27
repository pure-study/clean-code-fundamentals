package net.will;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <h3>Video Book: Clean Code Fundamentals</h3>
 * <p>Robert C. Martin
 *
 * <p>Advanced Test-Driven Development (TDD), Part 2
 */
public class WrapperTest {
    @Test
    public void shouldWrap() {
        assertEquals("", wrap(null, 1));
        assertEquals("", wrap("", 1));
        assertEquals("x", wrap("x", 1));
        assertEquals("x\nx", wrap("xx", 1));
        assertEquals("x\nx\nx", wrap("xxx", 1));

        assertEquals("x\nx", wrap("x x", 1));
        assertEquals("x\nxx", wrap("x xx", 3));
        assertEquals("four\nscore\nand\nseven\nyears\nago our\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt",
                wrap("four score and seven years ago our fathers brought forth upon this continent", 7));
    }

    private String wrap(String s, int width) {
        if (s == null) {
            return "";
        }

        if (s.length() <= width) {
            return s;
        }

        int breakPoint = s.lastIndexOf(" ", width);
        if (breakPoint < 0) {
            breakPoint = width;
        }
        return s.substring(0, breakPoint) + "\n" + wrap(s.substring(breakPoint).trim(), width);
    }
}
