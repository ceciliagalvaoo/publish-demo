package hr.lendit.pricing;

import java.math.BigDecimal;

public final class LateFee {
    private LateFee() {}

    public static BigDecimal calculate(int daysKept) {
        int daysLate = daysKept - 14;
        if (daysLate <= 0) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal("0.50").multiply(BigDecimal.valueOf(daysLate)).min(new BigDecimal("10.00"));
    }
}
