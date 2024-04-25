package com.aluracursos.servicio;

import com.aluracursos.api.ConsultaMoneda;
import java.util.Scanner;

public class MonedaServicio {

    private final Scanner leer = new Scanner(System.in);
    private ConsultaMoneda consultaMoneda = new ConsultaMoneda();
    private final String USD = "USD";
    private final String ARS = "ARS";
    private final String BRL = "BRL";
    private final String COP = "COP";
    int opcion = 0;
    private boolean menu = true;

    public void menu() {
        System.out.println("Bienvenido/a al Conversor de Moneda.");
        while (menu) {
            System.out.println("""
            ***********************************************
            1) Dólar ===> Peso argentino.
            2) Peso argentino ===> Dólar.
            3) Dólar ===> Real brasileño.
            4) Real brasileño ===> Dólar.
            5) Dólar ===> Peso colombiano.
            6) Peso colombiano ===> Dólar.
            7) Salir.
            Elija una opción válida:
            ***********************************************
            """);
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    consultaMoneda.convertirMoneda(leer, USD, ARS);
                    break;
                case 2:
                    consultaMoneda.convertirMoneda(leer, ARS, USD);
                    break;
                case 3:
                    consultaMoneda.convertirMoneda(leer, USD, BRL);
                    break;
                case 4:
                    consultaMoneda.convertirMoneda(leer, BRL, USD);
                    break;
                case 5:
                    consultaMoneda.convertirMoneda(leer, USD, COP);
                    break;
                case 6:
                    consultaMoneda.convertirMoneda(leer, COP, USD);
                    break;
                case 7:
                    menu = false;
                    System.out.println("Gracias por utilizar el Conversor de Moneda.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;

            }
        }
    }


}
