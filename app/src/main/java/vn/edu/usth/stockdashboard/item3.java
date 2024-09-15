package vn.edu.usth.stockdashboard;

public class item3 {
    private String buy;
    private String date;
    private String amount;
    private String fullname;

    public String getDate() {
        return date;
    }

    public String getAmount() {
        return amount;
    }

    public String getFullname() {
        return fullname;
    }

    public item3(String buy, String date, String amount, String fullname) {
        this.buy = buy;
        this.date = date;
        this.amount = amount;
        this.fullname = fullname;
    }

    public String getBuy() {
        return buy;
    }

}
