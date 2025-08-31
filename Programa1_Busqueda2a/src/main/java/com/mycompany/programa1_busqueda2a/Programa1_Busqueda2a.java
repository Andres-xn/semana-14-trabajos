/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.programa1_busqueda2a;

/**
 *
 * @author ANDACHI
 */
public class Programa1_Busqueda2a {

    // Busca un valor y devuelve [fila, columna] o [-1, -1] si no está
    public static int[] buscar(int[][] matriz, int objetivo) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == objetivo) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] matriz = {
                {8, 3, 5},
                {1, 9, 7},
                {4, 6, 2}
        };

        int objetivo = 7; // cambia este valor para probar
        int[] pos = buscar(matriz, objetivo);

        if (pos[0] != -1) {
            System.out.println("Valor " + objetivo +
                    " encontrado en [fila=" + pos[0] + ", columna=" + pos[1] + "]");
        } else {
            System.out.println("Valor " + objetivo + " no se encontró en la matriz.");
        }
    }
}

