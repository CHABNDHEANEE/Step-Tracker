public class StepTracker {
    int goalSteps = 10000;  //Цель

    MonthData[] monthToData;
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {   //Стата по месяцам
        int[] steps = new int[30];  //Массив с шагами по дням

        void saveSteps(int day, int step) {     //Сохраняем новое значение шагов за день
            steps[day] = step;
        }

        int calcTotalSteps() {      //Считаем общее количество шагов
            int total = 0;
            for (int step : steps) {
                total += step;
            }
            return total;
        }

        void printStatByDays() {    //Печатаем статистику по дням
            for(int i = 0; i < steps.length; i++) {
                System.out.print((i + 1) + " день: " + steps[i] + ", ");
            }
            System.out.println();
        }

        int getMaxSteps() {     //Находим день с максимальным количеством шагов
            int max = 0;
            for (int step : steps) {
                if (max < step) max = step;
            }
            return max;
        }

        String getAverageSteps() {      //Получаем среднее значение за месяц
            return String.format("%.2f", (calcTotalSteps() / 30.0));
        }

        int findBestSer() {     //Находим лучшую серию за месяц
            int inRow = 0;
            int bestInRow = 0;
            for (int step : steps) {
                if (step >= goalSteps) inRow++;
                else {
                    if (bestInRow < inRow) bestInRow = inRow;
                    inRow = 0;
                }
            }
            return bestInRow;
        }
    }
}
