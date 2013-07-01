package cannon.register.model;

/**
 * Created with IntelliJ IDEA.
 * User: lnac98
 * Date: 6/27/13
 * Time: 9:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class ChargeInfo {
    private int amount;
    private String currency;
    private String description;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
