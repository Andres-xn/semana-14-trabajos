/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tareahashmap;

/**
 *
 * @author ANDACHI
 */
import java.util.HashMap;
import java.util.Map;

public class TareaHashMap {
    public static void main(String[] args) {
        // 1 Crear el mapa
        Map<String, Object> informacionPersonal = new HashMap<>();
        informacionPersonal.put("Nombre", "Andres Andachi");
        informacionPersonal.put("Edad", 21);               // Integer como Object
        informacionPersonal.put("Canton", "Chillanes");

        // 2 Acceder y modificar valores: cambiar "ciudad" y agregar "profesion"
        System.out.println("Ciudad original: " + informacionPersonal.get("Ciudad"));
        informacionPersonal.put("Ciudad", "San Jose del Tambo");     // reemplazo
        informacionPersonal.put("Profesion", "Estudiante de TIC");

        // 3 Verificar existencia de "telefono" y agregar si no existe
        if (!informacionPersonal.containsKey("telefono")) {
            informacionPersonal.putIfAbsent("telefono", "0979650621");
        }

        // 4 Eliminar la clave "edad"
        informacionPersonal.remove("Edad");

        // 5 Imprimir el resultado
        System.out.println("\nContenido final del HashMap (orden NO garantizado):");
        System.out.println(informacionPersonal);  // impresión directa del mapa

        // Impresión formateada (una por línea)
        System.out.println("\nImpresion formateada:");
        imprimirMapa(informacionPersonal);
    }

    private static void imprimirMapa(Map<String, Object> mapa) {
        for (Map.Entry<String, Object> e : mapa.entrySet()) {
            System.out.println(e.getKey() + " => " + e.getValue());
        }
    }
}