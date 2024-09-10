package vn.edu.usth.stockdashboard;

public class item {
    private int chart;
    private int imageID;
    private int percent;

    public item(int imageID, int chart, int percent) {
        this.imageID = imageID;
        this.chart = chart;
        this.percent=percent;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getChart() {
        return chart;
    }

    public void setChart(int chart) {
        this.chart = chart;
    }
}
