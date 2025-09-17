/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendaexpres;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.UUID;
import java.text.NumberFormat;
import java.util.Locale;
        

/**
 *
 * @author ANDACHI
 */
public class TiendaExpres {

    // IVA de referencia (Ecuador): 12%
    private static final double IVA = 0.12;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> carrito = new ArrayList<>();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion(sc);
            switch (opcion) {
                    
                case 1 -> {
                    double precio = leerPrecio(sc);
                    agregarProducto(carrito, precio);
                }
                case 3 -> pagar(carrito, sc);
                case 4 -> System.out.println("Gracias por usar Tienda Express. ¡Hasta luego!");
                default -> System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 4);

        sc.close();
    }

    /** Imprime el menú principal. */
    static void mostrarMenu() {
        System.out.println("\n====== TIENDA EXPRESS ======");
        System.out.println("1. Agregar producto");
        System.out.println("3. Pagar");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
    }

    /** Lee una opción entera con control de errores. */
    static int leerOpcion(Scanner sc) {
        while (true) {
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Escriba un número (1, 3 o 4): ");
            }
        }
    }

    /** Lee un precio (double) no negativo con control de errores. */
    static double leerPrecio(Scanner sc) {
        System.out.print("Ingrese el precio del producto en USD (ej. 9.99): ");
        while (true) {
            String linea = sc.nextLine().trim().replace(",", ".");
            try {
                double precio = Double.parseDouble(linea);
                if (precio < 0) {
                    System.out.print("El precio no puede ser negativo. Intente de nuevo: ");
                    continue;
                }
                return precio;
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número decimal (ej. 12.50): ");
            }
        }
    }

    /** Agrega un producto (su precio) al carrito. */
    static void agregarProducto(List<Double> carrito, double precio) {
        carrito.add(precio);
        System.out.println("Producto agregado: " + formatearUSD(precio) +
                           " | Cantidad en carrito: " + carrito.size());
    }

    /** Calcula el total con impuesto: base * (1 + imp). */
    static double total(double base, double imp) {
        return base * (1.0 + imp);
    }

    /** Flujo de pago: suma, muestra reporte, pide correo y confirma. */
    static void pagar(List<Double> carrito, Scanner sc) {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío. Agregue productos antes de pagar.");
            return;
        }

        double subtotal = carrito.stream().mapToDouble(Double::doubleValue).sum();
        double totalConIva = total(subtotal, IVA);
        double valorIva = totalConIva - subtotal;

        // Reporte breve
        System.out.println("\n------ REPORTE DE COMPRA ------");
        for (int i = 0; i < carrito.size(); i++) {
            System.out.println("Producto " + (i + 1) + ": " + formatearUSD(carrito.get(i)));
        }
        System.out.println("-------------------------------");
        System.out.println("Subtotal: " + formatearUSD(subtotal));
        System.out.println("IVA (" + (int)(IVA * 100) + "%): " + formatearUSD(valorIva));
        System.out.println("TOTAL:    " + formatearUSD(totalConIva));
        System.out.println("-------------------------------");

        // Solicita correo para confirmar
        String correo;
        do {
            System.out.print("Ingrese su correo para confirmar la compra: ");
            correo = sc.nextLine().trim();
            if (!esCorreoValido(correo)) {
                System.out.println("Correo inválido. Intente nuevamente (ej: usuario@AndresAndachi.com).");
            }
        } while (!esCorreoValido(correo));

        confirmarCompra(correo, totalConIva);

        // Limpia el carrito después del pago
        carrito.clear();
    }

    /** Confirma la compra mostrando un mensaje final. */
    static void confirmarCompra(String correo, double total) {
        String id = generarIdTransaccion();
        System.out.println("\n✅ Compra confirmada");
        System.out.println("Transacción: " + id);
        System.out.println("Cliente: " + correo);
        System.out.println("Total pagado: " + formatearUSD(total));
        System.out.println("¡Gracias por su compra!");
    }

    /** Valida un correo electrónico simple con regex. */
    static boolean esCorreoValido(String correo) {
        String patron = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$";
        return Pattern.compile(patron).matcher(correo).matches();
    }

    /** Genera un ID sencillo para la transacción. */
    static String generarIdTransaccion() {
        return "TX-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    /** Formatea números en USD para consola. */
    static String formatearUSD(double valor) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        return nf.format(valor);
    }
}