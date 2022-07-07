import java.util.Scanner;

public class StepTracker {
    Converter converter;
    final MonthData[] monthToData; //Сделал константой.
    int goal;

     StepTracker() {
        monthToData = new MonthData[12];
        converter = new Converter();
        goal = 10000;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void saveSteps(int month, int day, int steps) {
         monthToData[month].setDaySteps(day, steps);
    }

    void getMonthlySumOfSteps(int month) {
        int sum = monthToData[month].getSumOfSteps();
        System.out.println("Количество шагов за месяц " + sum);
    }

    void getStatForAllDays(int month) {
        for (int i = 0; i < monthToData[month].getDays().length; i++) {
            System.out.println((i + 1) + "-й день: " + monthToData[month].getDaySteps(i));
        }
    }


    void getMonthlyAverageOfSteps(int month) {
        int sum = monthToData[month].getSumOfSteps();
        int days = monthToData[month].getDays().length;
        System.out.println("Среднее количество шагов за месяц: " + (sum / days));
    }

    void getMonthlyMaxOfSteps(int month) {
        int max = 0;
        for (int i = 0; i < monthToData[month].getDays().length; i++) {
            if (monthToData[month].getDaySteps(i) > max) {
                max = monthToData[month].getDaySteps(i);
            }
        }
        System.out.println("Максимум шагов за месяц: " + max);
    }

    void getDistance(int month) {
        int sum = monthToData[month].getSumOfSteps();
        System.out.println("Пройдено километров: " + converter.convertStepsToKm(sum));
    }

    void getKcal(int month) {
        int sum = monthToData[month].getSumOfSteps();
        System.out.println("Килокалорий сожжено: " + converter.convertStepsToKcal(sum));
    }

    void swapGoal(int aim) {
        goal = aim;
        System.out.println("Значение цели изменено.");
    }

    void getBestResult(int month) {
        int bestResult = 0;
        int bestResultNew = 0;
        for (int i = 0; i < monthToData[month].getDays().length; i++) {
            if (monthToData[month].getDaySteps(i) >= goal) {
                bestResultNew++;
            } else {
                if (bestResultNew > bestResult) {
                    bestResult = bestResultNew;
                }
            bestResultNew = 0;
            }
        }
        if (bestResultNew > bestResult) {
            bestResult = bestResultNew;
        }
        System.out.println(bestResult + " дней - лучшая серия.");
    }
    class MonthData {
        int[] days;

        MonthData() {
            days = new int[30];
        }

        int[] getDays() {
            return days;
        }

        int getDaySteps(int day) {
            return days[day];
        }

        void setDaySteps(int day, int steps) {
            days[day] = steps;
        }

        int getSumOfSteps() {
            int sum = 0;
            for (int i = 0; i < days.length; i++) {
                sum = sum + days[i];
            }
            return sum;
        }
    }

   void changeGoal(StepTracker stepTracker, Scanner scanner) { //Перенес из класса Main в StepTracker и убрал модификатор static.
        System.out.println("Введите значение новой цели.");
        int steps = scanner.nextInt();
        while (steps < 0) {
            System.out.println("Значение не может быть меньше нуля");
            System.out.println("Введите значение новой цели.");
            steps = scanner.nextInt();
        }
        stepTracker.swapGoal(steps);
    }

    void saveSteps(StepTracker stepTracker, Scanner scanner) { //Перенес из класса Main в StepTracker и убрал модификатор static.
        System.out.println("Введите месяц в числовом выражении (от 1 до 12).");
        int month = scanner.nextInt();
        while (month < 1 || month > 12) {
            System.out.println("Неправильный ввод. Доступные значения от 1 до 12.");
            System.out.println("Введите месяц в числовом выражении (от 1 до 12).");
            month = scanner.nextInt();
        }
        System.out.println("Введите день в числовом выражении (от 1 до 30).");
        int day = scanner.nextInt();
        while (day < 1 || day > 30) {
            System.out.println("Неправильный ввод. Доступные значения от 1 до 30.");
            System.out.println("Введите день в числовом выражении (от 1 до 30).");
            day = scanner.nextInt();
        }
        System.out.println("Введите количество шагов.");
        int steps = scanner.nextInt();
        while (steps < 0) {
            System.out.println("Количество шагов не может быть меньше нуля");
            System.out.println("Введите количество шагов.");
            steps = scanner.nextInt();
        }
        stepTracker.saveSteps(month - 1, day - 1, steps);
        System.out.println("Количество шагов сохранено.");
    }
    void getStatistics(StepTracker stepTracker, Scanner scanner) { //Перенес из класса Main в StepTracker и убрал модификатор static.
        System.out.println("Введите месяц в числовом выражении (от 1 до 12).");
        int month = scanner.nextInt();
        while (month < 1 || month > 12) {
            System.out.println("Неправильный ввод. Доступные значения от 1 до 12.");
            System.out.println("Введите месяц в числовом выражении (от 1 до 12).");
            month = scanner.nextInt();
        }
        stepTracker.getWholeStatistics(month - 1);
    }
    void getWholeStatistics(int month) {
        getStatForAllDays(month);
        getMonthlySumOfSteps(month);
        getMonthlyAverageOfSteps(month);
        getMonthlyMaxOfSteps(month);
        getBestResult(month);
        getDistance(month);
        getKcal(month);
    }
}