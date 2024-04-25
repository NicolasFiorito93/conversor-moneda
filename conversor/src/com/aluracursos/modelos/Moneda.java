package com.aluracursos.modelos;

import java.util.Map;

public record Moneda(String base_code,
                     Map<String, Double> conversion_rates,
                     String time_last_update_utc) {
}
