package net.will.tdd.advanced;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <h3>Video Book: Clean Code Fundamentals</h3>
 * <p>Robert C. Martin</p>
 *
 * <p>Advanced Test-Driven Development (TDD), Part 2</p>
 */
public class PrimeFactorsTest {
    @Test
    public void canFactorIntoPrimes() {
        assertEquals(Arrays.asList(), of(1));
        assertEquals(Arrays.asList(2), of(2));
        assertEquals(Arrays.asList(3), of(3));
        assertEquals(Arrays.asList(2, 2), of(4));
        assertEquals(Arrays.asList(5), of(5));
        assertEquals(Arrays.asList(2, 3), of(6));
        assertEquals(Arrays.asList(7), of(7));
        assertEquals(Arrays.asList(2, 2, 2), of(8));
        assertEquals(Arrays.asList(3, 3), of(9));
        assertEquals(Arrays.asList(2, 5), of(10));
        assertEquals(Arrays.asList(5, 5), of(25));
        assertEquals(Arrays.asList(5, 7), of(35));
        assertEquals(Arrays.asList(7, 7), of(49));
        assertEquals(Arrays.asList(2, 3, 3, 11, 13), of(2*3*3*11*13));
    }

    private List<Integer> of(int n) {
        List<Integer> factors = new ArrayList<>();

        for (int divisor = 2; n > 1; divisor++) {
            for (; n % divisor == 0; n /= divisor) {
                factors.add(divisor);
            }
        }

        return factors;
    }
}
