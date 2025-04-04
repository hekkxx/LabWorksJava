package org.example;

import java.util.Scanner;
import java.util.Random;

public class MatrixOperations {

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размеров матрицы
        System.out.print("Введите количество строк (не более 20): ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов (не более 20): ");
        int cols = scanner.nextInt();

        if (rows > 20 || cols > 20) {
            System.out.println("Размер матрицы не должен превышать 20x20.");
            return;
        }

        // Выбор способа создания матрицы
        System.out.println("Введите 1 для ручного ввода или 2 для рандомного заполнения:");
        int choice = scanner.nextInt();

        int[][] matrix;
        if (choice == 1) {
            matrix = createMatrixManually(scanner, rows, cols);
        } else {
            matrix = createMatrixRandomly(rows, cols);
        }

        // Вывод матрицы
        System.out.println("Созданная матрица:");
        printMatrix(matrix);

        // Нахождение минимального и максимального элементов
        int min = findMin(matrix);
        int max = findMax(matrix);

        // Вычисление средних значений
        double arithmeticMean = computeArithmeticMean(matrix);
        double geometricMean = computeGeometricMean(matrix);

        // Вывод результатов
        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Арифметическое среднее: " + arithmeticMean);
        System.out.println("Среднее геометрическое: " + geometricMean);

        scanner.close();
    }

    // Ручной ввод матрицы
    public static int[][] createMatrixManually(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Элемент [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // Рандомное заполнение матрицы
    public static int[][] createMatrixRandomly(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = MIN_VALUE + random.nextInt(MAX_VALUE - MIN_VALUE + 1);
            }
        }
        return matrix;
    }

    // Вывод матрицы
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    // Поиск минимального элемента
    public static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }
        return min;
    }

    // Поиск максимального элемента
    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }

    // Вычисление арифметического среднего
    public static double computeArithmeticMean(int[][] matrix) {
        double sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }
        return sum / count;
    }

    // Вычисление геометрического среднего
    public static double computeGeometricMean(int[][] matrix) {
        double product = 1.0;
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                product *= element;
                count++;
            }
        }
        // Если матрица содержит 0, геометрическое среднее будет 0
        return (product == 0) ? 0 : Math.pow(product, 1.0 / count);
    }
}
