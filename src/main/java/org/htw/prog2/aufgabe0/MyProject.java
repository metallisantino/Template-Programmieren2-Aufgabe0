package org.htw.prog2.aufgabe0;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.SwingWrapper;

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
        // Schritt 1: Eine Liste für die Iterationen erstellen
        java.util.LinkedList<Double> iterationen = new java.util.LinkedList<>();
        // Schritt 2: Den Startwert in die Liste einfügen
        iterationen.add(initial);
        // Schritt 3: Eine Variable für die aktuelle Näherung (beginnt mit initial)
        double aktuell = initial;
        // Schritt 4: Schleife: wir rechnen, bis der Fehler klein genug is (while-Schleife, die wir bei Bedarf abbrechen)
        while(true) {
            // Fehler berechnen: (value - X2) / (2 * X)
            double fehler = (value - (aktuell * aktuell)) / (2 * aktuell);
            // Neue Näherung: X = X + Fehler
            double neu = aktuell + fehler;
            // Neue Näherung in die Liste einfügen
            iterationen.add(neu);
            if (Math.abs(fehler) <= maxerror){
                break; // Genauigkeit erreicht: Schleife beenden. Wenn |Fehler| <= maxerror, dann Schleife abbrechen
            }
            aktuell = neu;
        }

        // Schritt 6: Liste in double[] umwandeln und zurückgeben
        double[] ergebnis = new double[iterationen.size()];
        for (int i=0; i < iterationen.size(); i++) {
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


