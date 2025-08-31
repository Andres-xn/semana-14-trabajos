/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.programa2_ordenacion2d;

/**
 *
 * @author ANDACHI
 */
import java.util.Arrays; // requerido si usas Arrays.sort o Arrays.toString

public class Programa2_Ordenacion2D {

    // Imprime la matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            System.out.println(Arrays.toString(fila));
        }
    }

    // Ordena una fila específica con Bubble Sort (ascendente)
    public static void ordenarFilaBubble(int[][] matriz, int indiceFila) {
        if (indiceFila < 0 || indiceFila >= matriz.length) {
            throw new IllegalArgumentException("Índice de fila fuera de rango");
        }
        int[] fila = matriz[indiceFila];
        boolean huboIntercambio;
        for (int i = 0; i < fila.length - 1; i++) {
            huboIntercambio = false;
            for (int j = 0; j < fila.length - 1 - i; j++) {
                if (fila[j] > fila[j + 1]) {
                    int tmp = fila[j];
                    fila[j] = fila[j + 1];
                    fila[j + 1] = tmp;
                    huboIntercambio = true;
                }
            }
            if (!huboIntercambio) break; // ya quedó ordenada
        }
    }

    // Variante opcional: ordena con Arrays.sort (ascendente)
    public static void ordenarFilaConArraysSort(int[][] matriz, int indiceFila) {
        if (indiceFila < 0 || indiceFila >= matriz.length) {
            throw new IllegalArgumentException("Índice de fila fuera de rango");
        }
        Arrays.sort(matriz[indiceFila]);
    }

    public static void main(String[] args) {
        int[][] matriz = {
                {9, 4, 1},
                {8, 5, 2},
                {7, 6, 3}
        };

        int filaAOrdenar = 1; // 0=primera, 1=segunda, 2=tercera

        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        // Elige un método:
        ordenarFilaBubble(matriz, filaAOrdenar);          // Bubble Sort
        // ordenarFilaConArraysSort(matriz, filaAOrdenar); // Arrays.sort

        System.out.println("\nMatriz tras ordenar la fila " + filaAOrdenar + ":");
        imprimirMatriz(matriz);
    }
}

