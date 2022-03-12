public class CreditCardValidation {

    private String digits;


    public void setDigits(String digits) {
        if (digits.length() < 13 || digits.length() > 16){
            throw new InvalidCardNumberException("Wrong Card Number");
        }
        else{
            this.digits = digits;
        }
    }

    public CreditCardValidation(String digits) {
        if (digits.length() < 13 || digits.length() > 16){
            throw new InvalidCardNumberException("Wrong Card Number");
        }
        else{
            this.digits = digits;
        }

    }

    public String getDigit() {
        return digits;
    }

    public String getCardType() {
        if (digits.startsWith("4")){
            return "Visa Card";
        }
        else if (digits.startsWith("5")){
            return "Masters Card";
        }
        else if (digits.startsWith("37")){
            return "American Express Card";
        }
        else if (digits.startsWith("6")){
            return "Discover Card";
        }
        else {
            throw new InvalidCardTypeException("Invalid Card Type");
//            return "Invalid Card Type";
        }
    }


    public boolean isValid() {
        return (digits.length() >= 13 && digits.length() <= 16)&&(digits.startsWith("4") || digits.startsWith("5") || digits.startsWith("37") || digits.startsWith("6")) &&((sumOfDoubleEvenNumber(digits) + sumOfOddNumber(digits))%10 == 0);
    }

    private int sumOfOddNumber(String digits) {
        int sum = 0;
        for (int i = digits.length() -1; i >= 0; i-=2){
            sum += Integer.parseInt(digits.charAt(i) + "");
        }
        return sum;
    }

    private int sumOfDoubleEvenNumber(String digits) {
        int sum = 0 ;
        for (int i = digits.length() - 2; i >= 0; i-=2){
            sum += getNumber(Integer.parseInt(digits.charAt(i) + "")* 2 );
        }
        return sum;
    }

    private int getNumber(int num) {
        boolean numberIsLessThanNine = num < 9;
      if (numberIsLessThanNine){
          return num;
      }
      else{
          return num/10 + num % 10;
      }
    }
}
