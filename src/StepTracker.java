public class StepTracker {
    int goalSteps = 10000;  //Цель

    MonthData[] monthToData;
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
        void saveSteps(int month, int day, int step) {     //Сохраняем новое значение шагов за день
            monthToData[month].steps[day] = step;
        }

        int calcTotalSteps(int month) {      //Считаем общее количество шагов
            int total = 0;
            for (int step : monthToData[month].steps) {
                total += step;
            }
            return total;
        }

        void printStatByDays(int month) {    //Печатаем статистику по дням
            for(int i = 0; i < monthToData[month].steps.length; i++) {
                System.out.print((i + 1) + " день: " + monthToData[month].steps[i] + ", ");
            }
            System.out.println();
        }

        int getMaxSteps(int month) {     //Находим день с максимальным количеством шагов
            int max = 0;
            for (int step : monthToData[month].steps) {
                if (max < step) max = step;
            }
            return max;
        }

        String getAverageSteps(int month) {      //Получаем среднее значение за месяц
            return String.format("%.2f", (calcTotalSteps(month) / 30.0));
        }

        int findBestSer(int month) {     //Находим лучшую серию за месяц
            int inRow = 0;
            int bestInRow = 0;
            for (int step : monthToData[month].steps) {
                if (step >= goalSteps) {
                    inRow++;
                } else {
                    if (bestInRow < inRow) bestInRow = inRow;
                    inRow = 0;
                }
            }
            if (bestInRow < inRow) bestInRow = inRow;
            return bestInRow;
        }
}
