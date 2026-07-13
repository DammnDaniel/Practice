package practice;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrentChallengeTest {

    @Test
    void sumsEvenNumbers() {
        assertEquals(12, CurrentChallenge.solve(List.of(1, 2, 4, 5, 6)));
    }

    @Test
    void emptyListReturnsZero() {
        assertEquals(0, CurrentChallenge.solve(List.of()));
    }
}
