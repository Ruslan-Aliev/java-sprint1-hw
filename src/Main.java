import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) { //Переделал код под SDK11.
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                stepTracker.saveSteps(stepTracker, scanner);
            } else if (userInput == 2) {
                stepTracker.getStatistics(stepTracker, scanner);
            } else if (userInput == 3) {
                stepTracker.changeGoal(stepTracker, scanner);
            } else if (userInput == 0) {
                System.out.println("Программа завершена.");
                return;
            } else {
                System.out.println("Такой команды нет.");
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
}

