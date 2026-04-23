package org.htw.prog2.aufgabe0;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.SwingWrapper;

import java.util.Arrays;
import java.util.LinkedList;

public class MyProject {

    /**
     * Calculate root X of a value S according to babylonian algorithm, starting with
     * an initial estimate X(0):
     * <ol>
     *     <li>Estimate the error e(n): e(n)=(S-X(n-1)²)/(2*X(n-1))</li>
     *     <li>Calculate X(n): X(n)=X(n-1)+e(n)</li>
     * </ol>
     * Continue until the estimated error reaches the desired maximum error
     * @param value The value to calculate the root of
     * @param initial The initial value to start the calculation with
     * @param maxerror The maximum allowed error
     * @return An array containing the values of all iterations. The last value in the array is the final estimate.
     */
    public static double[] calculateBabylonianRoot(double value, double initial, double maxerror) {
        // TODO: Implementieren.
        // 1. X(n) und e(n) erstellen.
        double xn = initial;
        double en;
        // 2. Liste für die Iterationen erstellen.
        java.util.LinkedList<Double> iterationen = new java.util.LinkedList<>();
        // 3. Startwert in Liste einfügen.
        iterationen.add(xn);
        // 4. do-while-Schleife: wir rechnen while |Fehler| > maxerror
        do {
            // e(n)=(S-X(n-1)²)/(2*X(n-1))
            en = (value-Math.pow(xn,2))/(2*xn);
            // X(n)=X(n-1)+e(n)
            xn=xn+en;
            // Neue Näherung in die Liste einfügen.
            iterationen.add(xn);
        } while (Math.abs(en) > maxerror); // Abbruch bei |Fehler| <= maxerror
        // 5. Liste in double[] umwandeln und zurückgeben.
        double[] ergebnis = new double[iterationen.size()];
        for (int i=0; i < iterationen.size(); i++) {ergebnis[i] = iterationen.get(i);}
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


