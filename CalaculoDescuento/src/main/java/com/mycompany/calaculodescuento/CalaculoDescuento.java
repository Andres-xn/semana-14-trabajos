/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calaculodescuento;

/**
 *
 * @author ANDACHI
 */
import java.text.DecimalFormat;

public class CalaculoDescuento {

    // Formateador para 2 decimales
    private static final DecimalFormat DF = new DecimalFormat("#,##0.00");

    /**
     * Calcula el valor del descuento aplicando un porcentaje explícito.
     * @param montoTotal           Monto base de la compra (>= 0)
     * @param porcentajeDescuento  Porcentaje a aplicar (0–100)
     * @return valor del descuento
     * @throws IllegalArgumentException si los parámetros son inválidos
     */
    public static double calcularDescuento(double montoTotal, double porcentajeDescuento) {
        validarEntradas(montoTotal, porcentajeDescuento);
        return montoTotal * (porcentajeDescuento / 100.0);
    }

    /**
     * Sobrecarga: aplica 10% por defecto.
     * @param montoTotal Monto base de la compra (>= 0)
     * @return valor del descuento (10%)
     */
    public static double calcularDescuento(double montoTotal) {
        final double DESCUENTO_POR_DEFECTO = 10.0; // 10%
        return calcularDescuento(montoTotal, DESCUENTO_POR_DEFECTO);
    }

    /** Devuelve el monto final a pagar: total - descuento (con límites de seguridad). */
    public static double montoFinal(double montoTotal, double descuento) {
        double finalPago = montoTotal - descuento;
        return finalPago < 0 ? 0 : finalPago;
    }

    /** Validaciones simples de entrada. */
    private static void validarEntradas(double montoTotal, double porcentajeDescuento) {
        if (montoTotal < 0) {
            throw new IllegalArgumentException("El monto total no puede ser negativo.");
        }
        if (porcentajeDescuento < 0 || porcentajeDescuento > 85) {
            throw new IllegalArgumentException("El porcentaje de descuento debe estar entre 0 y 100.");
        }
    }

    public static void main(String[] args) {
        // Caso 1: usando el 10% por defecto (sobrecarga)
        double total1 = 180.00;
        double desc1 = calcularDescuento(total1); // 25%
        double final1 = montoFinal(total1, desc1);

        // Caso 2: usando un porcentaje explícito (por ejemplo, 15%)
        double total2 = 240.00;
        double desc2 = calcularDescuento(total2, 15.0);
        double final2 = montoFinal(total2, desc2);

        // Salidas solicitadas
        System.out.println("=== Cálculo de Descuento ===");
        System.out.println("[Caso 1] Total: $" + DF.format(total1));
        System.out.println("Descuento (25%): $" + DF.format(desc1));
        System.out.println("Monto final: $" + DF.format(final1));
        System.out.println();

        System.out.println("[Caso 2] Total: $" + DF.format(total2));
        System.out.println("Descuento (5%): $" + DF.format(desc2));
        System.out.println("Monto final: $" + DF.format(final2));
    }
}

