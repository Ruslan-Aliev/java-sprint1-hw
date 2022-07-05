import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1 -> saveSteps(stepTracker, scanner);
                case 2 -> getStatistics(stepTracker, scanner);
                case 3 -> changeGoal(stepTracker, scanner);
                case 0 -> {
                    System.out.println("Программа завершена.");
                    return;
                }
                default -> System.out.println("Такой команды нет.");
            }
        }

    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определенный день.");
        System.out.println("2 - Напечатать статистику за определенный месяц.");
        System.out.println("3 - Внести изменения в количество шагов за день.");
        System.out.println("0 - Выйти из приложения.");
    }

    public static void changeGoal(StepTracker stepTracker, Scanner scanner) {
        System.out.println("Введите значение новой цели.");
        int steps = scanner.nextInt();
        while (steps < 0) {
            System.out.println("Значение не может быть меньше нуля");
            System.out.println("Введите значение новой цели.");
            steps = scanner.nextInt();
        }
        stepTracker.swapGoal(steps);
    }

    public static void saveSteps(StepTracker stepTracker, Scanner scanner) {
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

    public static void getStatistics(StepTracker stepTracker, Scanner scanner) {
        System.out.println("Введите месяц в числовом выражении (от 1 до 12).");
        int month = scanner.nextInt();
        while (month < 1 || month > 12) {
            System.out.println("Неправильный ввод. Доступные значения от 1 до 12.");
            System.out.println("Введите месяц в числовом выражении (от 1 до 12).");
            month = scanner.nextInt();
        }
        stepTracker.getWholeStatistics(month - 1);
    }
} 