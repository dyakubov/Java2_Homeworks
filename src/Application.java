import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        int step = 1; //Переменная для вывода в консоль текущую итерация цикла тестовых примеров

        //Пример 1: Массив некорректного размера
        String[][] a = {
                {"2", "3", "2", "3", "2"},
                {"2", "4", "5","5", "6"},
                {"2", "3", "4", "4", "5"},
                {"2", "3", "4", "4", "5"},
                {"2", "3", "4", "4", "5"}
        };

        //Пример 2: Массив, содержащий некорректное значение ячейки
        String[][] b = {
                {"1", "1", "привет", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "2"}
        };

        //Пример 3: Корректный массив
        String[][] c = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        ArrayList<String[][]> testArr = new ArrayList<>();
        testArr.add(a);
        testArr.add(b);
        testArr.add(c);

        //Попробуем прогнать через метод все 3 массива
        for (String[][] testCase : testArr) {
            System.out.println("Пример: " + step);
            try {
                arrayAddition(testCase);
            } catch (MyArraySizeException | MyArrayDataException ex) {
                System.out.println(ex.getMessage());
            }
            step++;
        }

    }


    private static void arrayAddition(String[][] testArray) throws MyArraySizeException, MyArrayDataException {
        System.out.println("Передача в метод arrayAddition() массива размером [" + testArray.length + "][" + testArray[0].length + "]");
        int sum = 0; // Текущая сумма элементов массива
        int current_row = 0; //Текущая строка массива
        int current_col = 0; //Текущий столбец массива
        String cellContent = ""; //Содержимой проверяемой ячейки

        if (testArray.length !=4){
            throw new MyArraySizeException("Ошибка: Некорректный размер массива");
        } else {
            try { //Пробуем просуммировать все элементы массива
                for (int i = 0; i < 4; i++) {
                    current_row = i;
                    for (int j = 0; j < 4; j++) {
                        current_col = j;
                        cellContent = testArray[i][j];
                        sum += Integer.parseInt(testArray[i][j]); //Преобразуем String в Integer и суммируем

                    }
                }
                System.out.println("Сумма элементов массива: " + sum);
            } catch (NumberFormatException ex) { //Ловим unchecked исключение и бросаем свое исключение;
                throw new MyArrayDataException("Ошибка: Невозможно преобразовать значение '" + cellContent + "' элемента массива [" + current_row + "][" + current_col + "] в число"); // Помимо сообщения передаем в конструктор исключения индекс ячейки, в которой возникла проблема

            }

        }
    }
}






