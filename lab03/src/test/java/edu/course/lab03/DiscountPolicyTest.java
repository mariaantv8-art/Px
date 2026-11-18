package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DiscountPolicyTest {


    @Test
    void testNoDiscount() {
        DiscountPolicy noDiscount = new NoDiscount();
        assertEquals(100.0, noDiscount.apply(100.0), 0.001);
    }

    @Test
    void testPercentDiscount() {
        DiscountPolicy twentyPercent = new PercentDiscount(20.0);
        assertEquals(80.0, twentyPercent.apply(100.0), 0.001);
    }

    @Test
    void testPercentDiscountInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(150.0));
    }

    @Test
    void testPriceCalculatorStrategyReplacement() {
        PriceCalculator calculator = new PriceCalculator(new NoDiscount());
        assertEquals(100.0, calculator.calculate(100.0), 0.001);

        calculator = new PriceCalculator(new PercentDiscount(10.0));
        assertEquals(90.0, calculator.calculate(100.0), 0.001);
    }
}