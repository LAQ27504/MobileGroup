package vn.edu.usth.stockdashboard;

public class item {
    private int chart;
    private int imageID;
    private int percent;
    private int fullImage;
    private int graphImage;

    public item(int imageID, int chart, int percent, int fullImage, int graphImage) {
        this.imageID = imageID;
        this.chart = chart;
        this.percent=percent;
        this.fullImage = fullImage;
        this.graphImage = graphImage;
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
    public int getFullImage() {
        return fullImage;
    }

    public int getGraphImage() {
        return graphImage;
    }
}
