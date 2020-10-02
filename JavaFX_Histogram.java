import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @web http://java-buddy.blogspot.com
 */
public class JavaFX_Histogram extends Application {

    int group[] = new int[10];

    @Override
    public void start(Stage primaryStage) {

        prepareData();

        Label labelInfo = new Label();
        labelInfo.setText(
            "java.version: " + System.getProperty("java.version") + "\n"
            + "javafx.runtime.version: " + System.getProperty("javafx.runtime.version")
        );

        //barChart1 with setAnimated(false)
        VBox vBoxBarChart1 = new VBox();
        final CategoryAxis xAxis1 = new CategoryAxis();
        final NumberAxis yAxis1 = new NumberAxis();
        final BarChart<String, Number> barChart1
        = new BarChart<>(xAxis1, yAxis1);
        barChart1.setCategoryGap(0);
        barChart1.setBarGap(0);
        barChart1.setMaxSize(500, 450);
        barChart1.setTitle("Summary");
        xAxis1.setLabel("Value");
        xAxis1.setTickLabelRotation(90);
        barChart1.setStyle("-fx-font: 30 arial black; -fx-base: gray;");
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2004");
        series1.getData().add(new XYChart.Data("0-10", group[0]));
        series1.getData().add(new XYChart.Data("10-20", group[1]));
        series1.getData().add(new XYChart.Data("20-30", group[2]));
        series1.getData().add(new XYChart.Data("30-40", group[3]));
        series1.getData().add(new XYChart.Data("40-50", group[4]));
        series1.getData().add(new XYChart.Data("50-60", group[5]));
        series1.getData().add(new XYChart.Data("60-70", group[6]));
        series1.getData().add(new XYChart.Data("70-80", group[7]));
        series1.getData().add(new XYChart.Data("80-90", group[8]));
        series1.getData().add(new XYChart.Data("90-100", group[9]));
    

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data("0-10", group[0]));
        series2.getData().add(new XYChart.Data("10-20", group[1]));
        series2.getData().add(new XYChart.Data("20-30", group[2]));
        series2.getData().add(new XYChart.Data("30-40", group[3]));
        series2.getData().add(new XYChart.Data("40-50", group[4]));
        series2.getData().add(new XYChart.Data("50-60", group[5]));
        series2.getData().add(new XYChart.Data("60-70", group[6]));
        series2.getData().add(new XYChart.Data("70-80", group[7]));
        series2.getData().add(new XYChart.Data("80-90", group[8]));
        series2.getData().add(new XYChart.Data("90-100", group[9]));
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
            series3.getData().add(new XYChart.Data("0-10", group[0]));
        series3.getData().add(new XYChart.Data("10-20", group[1]));
        series3.getData().add(new XYChart.Data("20-30", group[2]));
        series3.getData().add(new XYChart.Data("30-40", group[3]));
        series3.getData().add(new XYChart.Data("40-50", group[4]));
        series3.getData().add(new XYChart.Data("50-60", group[5]));
        series3.getData().add(new XYChart.Data("60-70", group[6]));
        series3.getData().add(new XYChart.Data("70-80", group[7]));
        series3.getData().add(new XYChart.Data("80-90", group[8]));
        series3.getData().add(new XYChart.Data("90-100", group[9]));

        barChart1.getData().addAll(series1,series2,series3);
        Label labelAnimated1 = new Label();
        barChart1.setAnimated(false);
        vBoxBarChart1.getChildren().addAll(barChart1, labelAnimated1);
        //- End of barChart1

        //PieChart2 with setAnimated(false)
        VBox vBoxPieChart2 = new VBox();

        ObservableList<PieChart.Data> pieChartData
        = FXCollections.observableArrayList(
                new PieChart.Data("0-10", group[0]),
                new PieChart.Data("10-20", group[1]),
                new PieChart.Data("20-30", group[2]),
                new PieChart.Data("30-40", group[3]),
                new PieChart.Data("40-50", group[4]),
                new PieChart.Data("50-60", group[5]),
                new PieChart.Data("60-70", group[6]),
                new PieChart.Data("70-80", group[7]),
                new PieChart.Data("80-90", group[8]),
                new PieChart.Data("90-100", group[9])
            );

        final PieChart pieChart2
        = new PieChart(pieChartData);
        pieChart2.setMaxSize(500, 450);

        Label labelAnimated2 = new Label();
        pieChart2.setAnimated(false);
        vBoxPieChart2.getChildren().addAll(pieChart2, labelAnimated2);
        //- End of pieChart2

        HBox hBoxCharts = new HBox();
        hBoxCharts.getChildren().addAll(vBoxBarChart1, vBoxPieChart2);

        Label labelCnt = new Label();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(labelInfo, hBoxCharts, labelCnt);

        StackPane root = new StackPane();
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 1000, 500);

        primaryStage.setTitle("java-buddy.blogspot.com");
        primaryStage.setScene(scene);
        primaryStage.show();

        Random random = new Random();

        //Apply Animating Data in Charts
        //ref: http://docs.oracle.com/javafx/2/charts/bar-chart.htm
        //"Animating Data in Charts" section
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(
            new KeyFrame(Duration.millis(200), (ActionEvent actionEvent) -> {

                    int data = random.nextInt(100);
                    /*
                    final int mean = 50;
                    final int standardDeviation = 10;
                    int data = mean + (int) (random.nextGaussian() * standardDeviation);
                     */
             
                    if (data <= 10) {
                        group[0]++;
                        series1.getData().set(0, new XYChart.Data("0-10", group[0]));
                        series2.getData().set(0, new XYChart.Data("0-10", group[0]));
                        series3.getData().set(0, new XYChart.Data("0-10", group[0]));
                        pieChartData.set(0, new PieChart.Data("0-10", group[0]));
                    } else if (data <= 20) {
                        group[1]++;
                        series1.getData().set(1, new XYChart.Data("10-20", group[1]));
                        series2.getData().set(1, new XYChart.Data("10-20", group[1]));
                        series3.getData().set(1, new XYChart.Data("10-20", group[1]));
                        pieChartData.set(1, new PieChart.Data("10-20", group[1]));
                    } else if (data <= 30) {
                        group[2]++;
                        series1.getData().set(2, new XYChart.Data("20-30", group[2]));
                        series2.getData().set(2, new XYChart.Data("20-30", group[2]));
                        series3.getData().set(2, new XYChart.Data("20-30", group[2]));
                        pieChartData.set(2, new PieChart.Data("20-30", group[2]));
                    } else if (data <= 40) {
                        group[3]++;
                        series1.getData().set(3, new XYChart.Data("30-40", group[3]));
                        series2.getData().set(3, new XYChart.Data("30-40", group[3]));
                        series3.getData().set(3, new XYChart.Data("30-40", group[3]));
                        pieChartData.set(3, new PieChart.Data("30-40", group[3]));
                    } else if (data <= 50) {
                        group[4]++;
                        series1.getData().set(4, new XYChart.Data("40-50", group[4]));
                        series2.getData().set(4, new XYChart.Data("40-50", group[4]));
                        series3.getData().set(4, new XYChart.Data("40-50", group[4]));
                        pieChartData.set(4, new PieChart.Data("40-50", group[4]));
                    } else if (data <= 60) {
                        group[5]++;
                        series1.getData().set(5, new XYChart.Data("50-60", group[5]));
                        series2.getData().set(5, new XYChart.Data("50-60", group[5]));
                        series3.getData().set(5, new XYChart.Data("50-60", group[5]));
                        pieChartData.set(5, new PieChart.Data("50-60", group[5]));
                    } else if (data <= 70) {
                        group[6]++;
                        series1.getData().set(6, new XYChart.Data("60-70", group[6]));
                        series2.getData().set(6, new XYChart.Data("60-70", group[6]));
                        series3.getData().set(6, new XYChart.Data("60-70", group[6]));
                        pieChartData.set(6, new PieChart.Data("60-70", group[6]));
                    } else if (data <= 80) {
                        group[7]++;
                        series1.getData().set(7, new XYChart.Data("70-80", group[7]));
                        series2.getData().set(7, new XYChart.Data("70-80", group[7]));
                        series3.getData().set(7, new XYChart.Data("70-80", group[7]));
                        pieChartData.set(7, new PieChart.Data("70-80", group[7]));
                    } else if (data <= 90) {
                        group[8]++;
                        series1.getData().set(8, new XYChart.Data("80-90", group[8]));
                        series1.getData().set(8, new XYChart.Data("80-90", group[8]));
                        series1.getData().set(8, new XYChart.Data("80-90", group[8]));
                        pieChartData.set(8, new PieChart.Data("80-90", group[8]));
                    } else if (data <= 100) {
                        group[9]++;
                        series1.getData().set(9, new XYChart.Data("10-100", group[9]));
                        pieChartData.set(9, new PieChart.Data("10-100", group[9]));
                    }

                    labelAnimated1.setText(
                        "barChart1.getAnimated() = " + barChart1.getAnimated());
                    labelAnimated2.setText(
                        "barChart2.getAnimated() = " + pieChart2.getAnimated());

                    String s = "";
                    for (int i = 0; i < 10; i++) {
                        s += " " + group[i];
                    }
                    labelCnt.setText(s);
                }));

        timeline.setCycleCount(1000);
        timeline.setAutoReverse(true);  //!?
        timeline.play();

    }

    public static void main(String[] args) {
        launch(args);
    }

    //generate dummy random data
    private void prepareData() {
        for (int i = 0; i < 10; i++) {
            group[i] = 0;
        }
    }

}