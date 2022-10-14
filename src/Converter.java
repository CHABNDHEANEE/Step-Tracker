public class Converter {

    String getDistance(int steps) {
        return String.format("%.2f", (steps * 0.75 / 1000));    //Считаем дистанцию в км и форматируем
    }

    String getCalories(int steps) {
        return String.format("%.2f", (steps * 50.0 / 1000.0));  //Считаем килокалории и форматируем до 2 символов после точки
    }
}
