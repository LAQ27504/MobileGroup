package vn.edu.usth.stockdashboard;

import android.widget.ImageView;

public class CompanyStockItem {
    private String logoUrl;

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent;
    }

    private String stockName;
    private String companyName;
    private String price;
    private String changePercent;

    public ImageView getPercent_icon() {
        return percent_icon;
    }

    public void setPercent_icon(ImageView percent_icon) {
        this.percent_icon = percent_icon;
    }

    private ImageView percent_icon;

    public CompanyStockItem(String stockName) {
        this.stockName = stockName;
    }


}
