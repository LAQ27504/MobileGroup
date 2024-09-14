package vn.edu.usth.stockdashboard;

public class item3 {
    private String buy;
    private String date;
    private String amount;

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

    public item3(String buy, String date, String amount) {
        this.date = date;
        this.amount = amount;
        this.buy = buy;
    }
}
