package org.htw.prog2.aufgabe0;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.SwingWrapper;

import java.util.LinkedList;

public class MyProject_ueben {

    public static double[] calculateBabylonianRoot(double value, double initial, double maxerror) {
        java.util.LinkedList<Double> iterationen = new java.util.LinkedList<>();
        iterationen.add(initial);
        double aktuell = initial;
        while (true) {
            double fehler = (value - (aktuell * aktuell)) / (2 * aktuell);
            double neu = aktuell + fehler;
            iterationen.add(neu);
            if (Math.abs(fehler) <= maxerror) {
                break;
            }
            aktuell = neu;
        }
        double[] ergebnis = new double[iterationen.size()];
        for (int i=0; i < iterationen.size(); i ++) {
            ergebnis[i] = iterationen.get(i);
        }
        return ergebnis;
    }

    public static void plotData(double[] values) {
        XYChart chart = new XYChart(500, 500);
        chart.addSeries("Data", values);
        new SwingWrapper(chart).displayChart();
    }

    public static void main(String[] args) {
       plotData(calculateBabylonianRoot(74821, 5, 0.1));
    }
}
