/* Дан целочисленный массив M*N, заполненный построчно случайными значениями в диапазоне от -99 до 99.
   Этот массив вывести на экран. Заменить исходный массив новым, в котором перед первым столбцом,
   содержащим только положительные элементы, вставлен столбец из единиц
   (номер столбца, содержащего только положительные элементы, может быть любым от 0 до N-1).
   Получившийся массив вывести на экран. Если требуемого столбца нет, то вывести без изменений. M и N задаются в main(). */

import java.util.Random;

public class Test2 {
    /* Метод для вывода массива на экран.
     array - двумерный массив для вывода. */
    public static void printArray(int array[][]) {
        for (int a[]: array) {
            for (int p: a) {
                System.out.printf("%4d", p);
            }
            System.out.println();
        }
        System.out.println();
    }

    /* Метод для поиска столбца, содержащего только положительные элементы.
     array - двумерный массив для поиска.
     Возвращает номер столбца, содержащего только положительные элементы, или -1, если такого столбца нет. */
    public static int findPositiveColumn(int array[][]) {
        int i, j;
        for (j = 0; j < array[0].length; j++) {
            i = 0;
            while (i < array.length) {
                if (array[i][j] <= 0) {
                    break;
                }
                i++;
            }
            if (i == array.length) {
                return j;
            }
        }
        return -1;
    }

    /* Метод для вставки столбца из единиц перед заданным столбцом.
     array - двумерный массив для изменения.
     column - номер столбца, перед которым нужно вставить столбец из единиц.
     Возвращает исходный двумерный массив со вставленным столбцом. */
    public static int[][] insertOnesColumn(int array[][], int column) {
        int i, j;
		int newLine[];
    for (i = 0; i < array.length; i++) {
      	newLine = new int[array[i].length + 1];
        for (j = 0; j < column; j++) {
            newLine[j] = array[i][j];
        }
            newLine[column] = 1;
            for (j = column; j < array[i].length; j++) {
              	newLine[j + 1] = array[i][j];
            }
            array[i] = newLine;
        }
        return array;
    }

    /* Метод для создания массива.
     M - количество строк в массиве.
     N - количество столбцов в массиве.
     Возвращает двумерный массив. */
    public static int[][] createArray(int M, int N) {
        int[][] array = new int[M][N];
        Random r = new Random();
        int i, j;
		for (i = 0; i < array.length; i++)
            for (j = 0; j < array[i].length; j++)
                array[i][j] = r.nextInt()%100;
        return array;
    }
    
    public static void main(String[] args) {
        // Создание исходного массива
        int M = 3;
        int N = 5;
        int[][] array = createArray(M, N);

        // Вывод исходного массива
        System.out.println("Исходный массив:");
        printArray(array);

        // Поиск столбца, содержащего только положительные элементы
        int column = findPositiveColumn(array);

        // Если такой столбец найден, вставка столбца из единиц
        if (column != -1) {
            array = insertOnesColumn(array, column);
        }

        // Вывод получившегося массива
        System.out.println("Результат:");
        printArray(array);
    }
}
