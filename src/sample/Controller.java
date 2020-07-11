package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.*;

public class Controller {

    private static class Task {
        String name;
        double releaseTime;
        double period;
        double executionTime;
        double deadline;
        int priority;
    }

    Task[] task = new Task[3];

    public AreaChart<Number,String> chart;
    public NumberAxis horizontalAxis;
    public CategoryAxis verticalAxis;

    @FXML
    private void initialize() {
        for (int i = 0; i < 3; i++) {
            task[i] = new Task();
        }
        draw();
    }

    private void draw(){
        getTaskParameters(0, "T1", 4, 1.5, 0);
        getTaskParameters(1, "T2", 10, 3, 1);
        getTaskParameters(2, "T3", 12, 3, 2);
        drawChart();
    }

    private void getTaskParameters(
            int taskNumber,
            String name,
            double period,
            double executionTime,
            int priority
    ) {
        task[taskNumber].name = name;
        task[taskNumber].releaseTime = 0;
        task[taskNumber].period = period;
        task[taskNumber].executionTime = executionTime;
        task[taskNumber].deadline = period;
        task[taskNumber].priority = priority;
    }

    private void seriesDraw(int seriesNumber, double startTime, double endTime, String taskName, String job) {
        series[seriesNumber].getData().add(new XYChart.Data<>(startTime, taskName));
        series[seriesNumber].getData().add(new XYChart.Data<>(endTime, taskName));
        series[seriesNumber].setName(job);
    }

    int count = 18;
    XYChart.Series<Number, String>[] series = new XYChart.Series[count];

    private void drawChart() {
        chart.getData().clear();
        for (int i = 0; i < count; i++) {
            series[i] = new XYChart.Series<>();
        }

        double startTime = task[0].releaseTime;
        double endTime = startTime + task[0].executionTime;
        seriesDraw(0, startTime, endTime, task[0].name, "J11");

        startTime = endTime;
        endTime = startTime + task[1].executionTime - 0.5;
        seriesDraw(1, startTime, endTime, task[1].name, "J21");

        startTime = endTime;
        endTime = startTime + task[0].executionTime;
        seriesDraw(2, startTime, endTime, task[0].name, "J12");

        startTime = endTime;
        endTime = startTime + task[2].executionTime - 0.5;
        seriesDraw(3, startTime, endTime, task[2].name, "J31");

        startTime = endTime;
        endTime = startTime + task[1].executionTime - 2.5;
        seriesDraw(4, startTime, endTime, task[1].name, "J21");

        startTime = endTime;
        endTime = startTime + task[0].executionTime;
        seriesDraw(5, startTime, endTime, task[0].name, "J13");

        startTime = endTime;
        endTime = startTime + task[2].executionTime - 2.5;
        seriesDraw(6, startTime, endTime, task[2].name, "J31");

        startTime = endTime;
        endTime = startTime + task[1].executionTime - 1.5;
        seriesDraw(7, startTime, endTime, task[1].name, "J22");

        startTime = endTime;
        endTime = startTime + task[0].executionTime;
        seriesDraw(8, startTime, endTime, task[0].name, "J14");

        startTime = endTime;
        endTime = startTime + task[1].executionTime - 1.5;
        seriesDraw(9, startTime, endTime, task[1].name, "J22");

        startTime = endTime;
        endTime = startTime + task[2].executionTime - 2;
        seriesDraw(10, startTime, endTime, task[2].name, "J32");

        startTime = endTime;
        endTime = startTime + task[0].executionTime;
        seriesDraw(11, startTime, endTime, task[0].name, "J15");

        startTime = endTime;
        endTime = startTime + task[2].executionTime - 1;
        seriesDraw(12, startTime, endTime, task[2].name, "J32");

        startTime = endTime + 0.5;
        endTime = startTime + task[0].executionTime;
        seriesDraw(13, startTime, endTime, task[0].name, "J16");

        startTime = endTime;
        endTime = startTime + 2.5;
        seriesDraw(14, startTime, endTime, task[1].name, "J23");

        startTime = endTime;
        endTime = startTime + task[0].executionTime;
        seriesDraw(15, startTime, endTime, task[0].name, "J17");

        startTime = endTime;
        endTime = startTime + task[1].executionTime - 2.5;
        seriesDraw(16, startTime, endTime, task[1].name, "J23");

        startTime = endTime;
        endTime = startTime + task[2].executionTime - 1;
        seriesDraw(17, startTime, endTime, task[2].name, "J33");

        chart.getData().addAll(series);
    }

}
