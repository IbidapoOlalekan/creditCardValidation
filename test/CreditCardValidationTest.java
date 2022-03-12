import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Credit Card")
class CreditCardValidationTest {
    CreditCardValidation creditCard;

    @BeforeEach
    public void setUp() {
        creditCard = new CreditCardValidation("4388576018410707");
    }

    @DisplayName("Number Can Be Set Test")
    @Test void creditCardNumberCanBeSetTest() {
        CreditCardValidation creditCard = new CreditCardValidation("4388576018402626");
        creditCard.setDigits("4388576018410707");
        assertEquals(creditCard.getDigit(),"4388576018410707");
    }


    @DisplayName("Have a number")
    @Test
    void creditCardHaveANumber() {
        assertEquals("4388576018410707", creditCard.getDigit());
    }


    @DisplayName("Card Must Have Between 13 And 16 Digits")
    @Test
    void creditCardHaveBetweenThirteenAndSixteenDigits() {
        assertThrows(InvalidCardNumberException.class, () -> creditCard.setDigits("000"));
    }

    @DisplayName("If Card Start With Four Its Visa Card")
    @Test void creditCardStartWithFour(){
        assertEquals("Visa Card",creditCard.getCardType());
    }

    @DisplayName("If card starts with 5 It's A Masters Card")
    @Test void creditCardStartWithFive(){
        CreditCardValidation creditCard = new CreditCardValidation("5388576018402626");
        assertEquals("Masters Card",creditCard.getCardType());
    }

    @DisplayName("If Card Start with 37 It is American Express Card")
    @Test void creditCardStartWithThirtySevenTest() throws Exception {
        CreditCardValidation creditCard = new CreditCardValidation("3788576018402626");
        assertEquals("American Express Card",creditCard.getCardType());
    }

    @DisplayName("If Card Start With 6 It is Discover Cards")
    @Test void creditCardStartWithSix(){
        CreditCardValidation creditCard = new CreditCardValidation("6788576018402626");
        assertEquals("Discover Card",creditCard.getCardType());
    }

    @DisplayName("Type Does Not Exist")
    @Test void creditCardTypeDoesNotExist(){
        CreditCardValidation creditCard = new CreditCardValidation("0788576018402626");
        assertThrows(InvalidCardTypeException.class, creditCard::getCardType);
    }


    @DisplayName("Validate If Credit Card Is Valid")
    @Test void creditCardNumberIsValid() {
        assertTrue(creditCard.isValid());
    }

    @DisplayName("Validate If Credit Card Is Invalid")
    @Test void creditCardIsInvalid() {
        CreditCardValidation creditCard = new CreditCardValidation("4388576018402626");
        assertFalse(creditCard.isValid());
    }
}
