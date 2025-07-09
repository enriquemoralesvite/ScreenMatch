package com.aluracursos.screenmatch.service;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class ConsultaGemini {
    public static String obtenerTraduccion(String texto) {
        String modelo = "gemini-2.0-flash-lite";
        String prompt = "Traduce el siguiente texto al español: " + texto;

        Client cliente = new Client.Builder().apiKey("${GEMINI_APIKEY}").build();

        try {
            GenerateContentResponse respuesta = cliente.models.generateContent(
                    modelo,
                    prompt,
                    null // Parámetro para configuraciones adicionales
            );

            if (!respuesta.text().isEmpty()) {
                String textoTraducido = respuesta.text();
                String prefijo = "Aquí tienes la traducción al español:";
                if (textoTraducido.startsWith(prefijo)) {
                    textoTraducido = textoTraducido.substring(prefijo.length()).trim();
                }
                return textoTraducido;
            }
        } catch (Exception e) {
            System.err.println("Error al llamar a la API de Gemini para traducción: " + e.getMessage());
        }

        return null;
    }
}
