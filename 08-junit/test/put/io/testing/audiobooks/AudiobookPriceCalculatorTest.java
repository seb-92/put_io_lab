package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {

    private AudiobookPriceCalculator audiobookPriceCalculator;
    private Customer customerSubscriber;
    private Customer customerSilver;
    private Customer customerGold;
    private Customer customerStandard;

    private Audiobook audiobook;

    @BeforeEach
    void setUp() {
        audiobookPriceCalculator = new AudiobookPriceCalculator();
        customerSubscriber = new Customer("customer1", Customer.LoyaltyLevel.GOLD, true);
        customerSilver = new Customer("customer2", Customer.LoyaltyLevel.SILVER, false);
        customerGold = new Customer("customer3", Customer.LoyaltyLevel.GOLD, false);
        customerStandard = new Customer("customer4", Customer.LoyaltyLevel.STANDARD, false);
        audiobook = new Audiobook("title", 151.2);
    }

    @Nested
    class CalculateTest {

        @Test
        void Return0IfCustomerIsSubscriber() {
            //given
            double expectedValue = 0.0;

            //when
            double result = audiobookPriceCalculator.calculate(customerSubscriber, audiobook);

            //then
            assertEquals(expectedValue, result);
        }

        @Test
        void Return10perCentDiscount() {
            //given
            double expectedValue = audiobook.getStartingPrice() * 0.9;

            //when
            double result = audiobookPriceCalculator.calculate(customerSilver, audiobook);

            //then
            assertEquals(expectedValue, result);
        }

        @Test
        void Return20perCentDiscount() {
            //given
            double expectedValue = audiobook.getStartingPrice() * 0.8;

            //when
            double result = audiobookPriceCalculator.calculate(customerGold, audiobook);

            //then
            assertEquals(expectedValue, result);
        }

        @Test
        void ReturnFullPrice() {
            //given
            double expectedValue = audiobook.getStartingPrice();

            //when
            double result = audiobookPriceCalculator.calculate(customerStandard, audiobook);

            //then
            assertEquals(expectedValue, result);
        }
    }
}