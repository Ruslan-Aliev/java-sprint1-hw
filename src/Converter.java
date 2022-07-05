public class Converter {
    final double stepLength = 0.75;
    final double kmLength = 1000;
    final double caloriesInKilocalories = 1000;
    final int caloriesPerStep = 50;

    double convertStepsToKm(int steps) {
        return steps * stepLength / kmLength;
    }

    double convertStepsToKcal(int steps) {
        return steps * caloriesPerStep / caloriesInKilocalories;
    }
}
