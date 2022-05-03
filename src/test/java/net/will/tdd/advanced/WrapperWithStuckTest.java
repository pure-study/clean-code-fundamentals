package net.will.tdd.advanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <h3>Video Book: Clean Code Fundamentals</h3>
 * <p>Robert C. Martin
 *
 * <p>Advanced Test-Driven Development (TDD), Part 2
 *
 * <p>This is the first try of a word wrapper, which gets stuck in the end. Getting stuck is a technical term that
 * means there's nothing incremental you can do to pass the currently failing test. But getting stuck is a symptom
 * of a problem. That problem could be either:
 * <ol>
 *     <li>You wrote the wrong test.</li>
 *     <li>You're making the production code too specific.</li>
 * </ol>
 * <p>Or maybe it's both.
 */
public class WrapperWithStuckTest {
    @Test
    public void shouldWrap() {
        assertEquals("word\nword", wrap("word word", 4));
        assertEquals("a dog", wrap("a dog", 5));
        assertEquals("a dog\nwith a\nbone", wrap("a dog with a bone", 6));
    }

    private String wrap(String s, int width) {
        return (s.length() > width) ? s.replaceAll(" ", "\n") : s;
    }
}
