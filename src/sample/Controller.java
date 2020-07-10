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
        getTaskParameters(0, "T1", 4, 1.5, 4, 0);
        getTaskParameters(1, "T2", 10, 3, 10, 1);
        getTaskParameters(2, "T3", 12, 3, 12, 2);
        drawChart();
    }

    private void getTaskParameters(
            int taskNumber,
            String name,
            double period,
            double executionTime,
            double deadline,
            int priority
    ) {
        task[taskNumber].name = name;
        task[taskNumber].releaseTime = 0;
        task[taskNumber].period = period;
        task[taskNumber].executionTime = executionTime;
        task[taskNumber].deadline = deadline;
        task[taskNumber].priority = priority;
    }

    private void drawChart() {
        chart.getData().clear();
        int count = 18;
        XYChart.Series[] series = new XYChart.Series[count];
        for (int i = 0; i < count; i++) {
            series[i] = new XYChart.Series();
        }

        double currentTime = task[0].releaseTime;

        series[0].getData().add(new XYChart.Data(currentTime, task[0].name));
        series[0].getData().add(new XYChart.Data(currentTime + task[0].executionTime, task[0].name));
        series[0].setName("J11");

        currentTime += task[0].executionTime;

        series[1].getData().add(new XYChart.Data(currentTime, task[1].name));
        series[1].getData().add(new XYChart.Data(currentTime + (4 - currentTime), task[1].name));
        series[1].setName("J21");

        currentTime += (4 - currentTime);

        series[2].getData().add(new XYChart.Data(currentTime, task[0].name));
        series[2].getData().add(new XYChart.Data(currentTime + task[0].executionTime, task[0].name));
        series[2].setName("J12");

        currentTime += task[0].executionTime;

        series[3].getData().add(new XYChart.Data(currentTime, task[2].name));
        series[3].getData().add(new XYChart.Data(currentTime + (8 - currentTime), task[2].name));
        series[3].setName("J31");

        currentTime += (8 - currentTime);

        series[4].getData().add(new XYChart.Data(currentTime, task[1].name));
        series[4].getData().add(new XYChart.Data(currentTime + 0.5, task[1].name));
        series[4].setName("J21");

        currentTime += 0.5;

        series[5].getData().add(new XYChart.Data(currentTime, task[0].name));
        series[5].getData().add(new XYChart.Data(currentTime + task[0].executionTime, task[0].name));
        series[5].setName("J13");

        currentTime += task[0].executionTime;

        series[6].getData().add(new XYChart.Data(currentTime, task[2].name));
        series[6].getData().add(new XYChart.Data(currentTime + 0.5, task[2].name));
        series[6].setName("J31");

        currentTime += 0.5;

        series[7].getData().add(new XYChart.Data(currentTime, task[1].name));
        series[7].getData().add(new XYChart.Data(currentTime + 1.5, task[1].name));
        series[7].setName("J22");

        currentTime += 1.5;

        series[8].getData().add(new XYChart.Data(currentTime, task[0].name));
        series[8].getData().add(new XYChart.Data(currentTime + task[0].executionTime, task[0].name));
        series[8].setName("J14");

        currentTime += task[0].executionTime;

        series[9].getData().add(new XYChart.Data(currentTime, task[1].name));
        series[9].getData().add(new XYChart.Data(currentTime + 1.5, task[1].name));
        series[9].setName("J22");

        currentTime += 1.5;

        series[10].getData().add(new XYChart.Data(currentTime, task[2].name));
        series[10].getData().add(new XYChart.Data(currentTime + 1, task[2].name));
        series[10].setName("J32");

        currentTime += 1;

        series[11].getData().add(new XYChart.Data(currentTime, task[0].name));
        series[11].getData().add(new XYChart.Data(currentTime + 1.5, task[0].name));
        series[11].setName("J15");

        currentTime += 1.5;

        series[12].getData().add(new XYChart.Data(currentTime, task[2].name));
        series[12].getData().add(new XYChart.Data(currentTime + 2, task[2].name));
        series[12].setName("J32");

        currentTime += 2.5;

        series[13].getData().add(new XYChart.Data(currentTime, task[0].name));
        series[13].getData().add(new XYChart.Data(currentTime + task[0].executionTime, task[0].name));
        series[13].setName("J16");

        currentTime += task[0].executionTime;

        series[14].getData().add(new XYChart.Data(currentTime, task[1].name));
        series[14].getData().add(new XYChart.Data(currentTime + 2.5, task[1].name));
        series[14].setName("J23");

        currentTime += 2.5;

        series[15].getData().add(new XYChart.Data(currentTime, task[0].name));
        series[15].getData().add(new XYChart.Data(currentTime + task[0].executionTime, task[0].name));
        series[15].setName("J17");

        currentTime += task[0].executionTime;

        series[16].getData().add(new XYChart.Data(currentTime, task[1].name));
        series[16].getData().add(new XYChart.Data(currentTime + 0.5, task[1].name));
        series[16].setName("J23");

        currentTime += 0.5;

        series[17].getData().add(new XYChart.Data(currentTime, task[2].name));
        series[17].getData().add(new XYChart.Data(currentTime + 2, task[2].name));
        series[17].setName("J33");

        chart.getData().addAll(series);
    }

}
