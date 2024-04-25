package com.aluracursos.api;

import com.aluracursos.modelos.Moneda;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaMoneda {

    public Moneda buscarMoneda(String moneda) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/75c78c7610ee9ccde348aefe/latest/" + moneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la moneda");
        }
    }

    public void convertirMoneda(Scanner leer, String monedaOriginal, String monedaCambiar) {
        System.out.println("Ingrese la cantidad a convertir: ");
        double cantidad = leer.nextDouble();
        Moneda moneda = buscarMoneda(monedaOriginal);
        double resultado = moneda.conversion_rates().get(monedaCambiar) * cantidad;
        String resultadoFormateado = String.format("%.2f", resultado);
        System.out.println(String.format("%.2f", cantidad) + " " + monedaOriginal + " convertido a " +
                monedaCambiar + " serian: " + resultadoFormateado);
}
}
