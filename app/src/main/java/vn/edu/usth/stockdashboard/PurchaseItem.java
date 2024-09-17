package vn.edu.usth.stockdashboard;

public class PurchaseItem {
    private String buy;
    private String date;
    private String amount;
    private String fullname;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public PurchaseItem(String buy, String date, String amount, String fullname) {
        this.date = date;
        this.amount = amount;
        this.buy = buy;
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }
}
