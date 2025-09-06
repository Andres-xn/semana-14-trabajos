/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.temperaturasdiarias;

/**
 *
 * @author ANDACHI
 */
public class TemperaturasDiarias {
    public static void main(String[] args) {
        // Definir ciudades
        String[] ciudades = {"Quito", "Guayaquil"};

        // Definir días de la semana
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

        // Definir semanas (ejemplo: 2 semanas)
        int semanas = 2;

        // Crear matriz 3D: [ciudad][día][semana]
        int[][][] temperaturas = new int[ciudades.length][dias.length][semanas];

        // Rellenar la matriz con valores de ejemplo
        // (en un caso real podrían pedirse al usuario o leerse de un archivo)
        for (int c = 0; c < ciudades.length; c++) {
            for (int s = 0; s < semanas; s++) {
                for (int d = 0; d < dias.length; d++) {
                    temperaturas[c][d][s] = (int)(Math.random() * 15 + 15); 
                    // Temperaturas entre 15 y 30 grados
                }
            }
        }

        // Calcular y mostrar el promedio de temperaturas
        for (int c = 0; c < ciudades.length; c++) {
            System.out.println("\nCiudad: " + ciudades[c]);
            for (int s = 0; s < semanas; s++) {
                int suma = 0;
                for (int d = 0; d < dias.length; d++) {
                    suma += temperaturas[c][d][s];
                }
                double promedio = (double) suma / dias.length;
                System.out.println("  Semana " + (s + 1) + ": Promedio = " + promedio + " °C");
            }
        }
    }
}

