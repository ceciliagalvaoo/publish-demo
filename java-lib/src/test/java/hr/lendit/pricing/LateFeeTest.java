package hr.lendit.pricing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LateFeeTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 14})
    void noFeeWithin14Days(int daysKept) {
        assertEquals(0, LateFee.calculate(daysKept).compareTo(BigDecimal.ZERO));
    }

    @Test
    void halfAUnitPerDayAfter14Days() {
        assertEquals(0, LateFee.calculate(20).compareTo(new BigDecimal("3.00")));
    }

    @Test
    void feeIsCappedAt10() {
        assertEquals(0, LateFee.calculate(100).compareTo(new BigDecimal("10.00")));
    }
}
