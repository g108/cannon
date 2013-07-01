package cannon.register.model;

/**
 * Created with IntelliJ IDEA.
 * User: lnac98
 * Date: 6/27/13
 * Time: 9:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class CardInfo {
    private String cardNumber;
    private int expirationMonth;
    private int expirationYear;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }
}
