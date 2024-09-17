package vn.edu.usth.stockdashboard;

public class item {
    private int chart;
    private int imageID;
    private int percent;
    private int fullImage;
    private int graphImage;
    private int daily;
    private int weekly;

    public item(int imageID, int chart, int percent, int fullImage, int graphImage, int daily, int weekly) {
        this.weekly = weekly;
        this.daily = daily;
        this.fullImage = fullImage;
        this.graphImage = graphImage;
        this.percent = percent;
        this.imageID = imageID;
        this.chart = chart;
    }

    public int getChart() {
        return chart;
    }

    public int getImageID() {
        return imageID;
    }

    public int getPercent() {
        return percent;
    }

    public int getFullImage() {
        return fullImage;
    }

    public int getGraphImage() {
        return graphImage;
    }

    public int getDaily() {
        return daily;
    }

    public int getWeekly() {
        return weekly;
    }
}
