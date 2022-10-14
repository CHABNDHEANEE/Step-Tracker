import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();

        while (true) {      //Цикл для работы приложения, завершается только если юзер захочет выйти из приложжения
            printMenu();
            int commandId = scanner.nextInt();

            if (commandId == 1) {   //Выводит кол-во шагов за день
                int month = inputMonth(scanner);
                int day = inputDay(scanner);
                int steps = inputSteps(scanner);
                stepTracker.saveSteps(month, day, steps);
                System.out.println("Шаги сохранены!");
            }
            else if (commandId == 2) {      //Печатает стату за месяц
                printStat(inputMonth(scanner), stepTracker, converter);
            }
            else if (commandId == 3) {
                System.out.println("Текущая цель: " + stepTracker.goalSteps);
                stepTracker.goalSteps = inputSteps(scanner);
                System.out.println("Новая цель сохранена!");
            }
            else if (commandId == 4) {
                System.out.println("Пока! :)");
                break;
            }
            else System.out.println("Данной команды не существует. Пожалуйста, выберите номер команды из списка.");
        }
    }

    public static void printMenu() {        //Печатаем менюшку
        System.out.println("1. Ввести количество шагов за день.");
        System.out.println("2. Напечатать статистику за определенный месяц.");
        System.out.println("3. Изменить цель по количеству шагов в день.");
        System.out.println("4. Выход из приложения.");
        System.out.println("Введите номер действия: ");
    }

    public static int inputMonth(Scanner scanner) {     //Запрашиваем и получаем от юзера месяц
        System.out.println("Введите номер месяца начиная с 0: ");
        return scanner.nextInt();
    }

    public static int inputDay(Scanner scanner) {       //Запрашиваем и получаем от юзерра день
        System.out.println("Введите день: ");
        int day = scanner.nextInt();
        if (day <= 0 || day > 30) {     //Проверяем корректность ввода
            System.out.println("Введен некорректный день! Попробуйте еще раз.");
            inputDay(scanner);
        }
        return day;
    }

    public static int inputSteps(Scanner scanner) {     //Запрашиваем и получаем от юзера кол-во шагов
        System.out.println("Введите количество шагов: ");
        int steps = scanner.nextInt();
        if (steps < 0) {        //Проверяем корректность ввода
            System.out.println("Введено некорректное количество шагов. Попробуйте еще раз.");
            inputSteps(scanner);
        }
        return steps;
    }

    public static void printStat(int month, StepTracker stepTracker, Converter converter) {     //Печаем стату за месяц, введенный юзерром
        System.out.println("Количество пройденных шагов по дням: ");
        stepTracker.printStatByDays(month);
        System.out.println("Общее количество шагов за месяц: " + stepTracker.calcTotalSteps(month));
        System.out.println("Макисмальное количество шагов: " + stepTracker.getMaxSteps(month));
        System.out.println("Среднее количество шагов за месяц: " + stepTracker.getAverageSteps(month));
        System.out.println("Пройденная дистанция: " + converter.getDistance(stepTracker.calcTotalSteps(month)));
        System.out.println("Количество сожжённых килокалорий: " + converter.getCalories(stepTracker.calcTotalSteps(month)));
        System.out.println("Лучшая серия: " + stepTracker.findBestSer(month));
    }
}
