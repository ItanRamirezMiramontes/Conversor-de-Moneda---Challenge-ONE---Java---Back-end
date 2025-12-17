import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {



    // Meotodo para obtener la tasa (le pasamos de parametro el codigo de la moneda)
    public double obtenerTasa(String codigoMoneda) {

        //Variables de el enlace donde vamos a acceder
        String key = "c484c13df954f584974a5759";
        String url = "https://v6.exchangerate-api.com/v6/" + key + "/latest/USD";

        // Configuración del Cliente y Solicitud
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            // Envío
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            // Transformación
            JsonObject jsonResponse = JsonParser.parseString(respuesta.body()).getAsJsonObject();
            JsonObject tasas = jsonResponse.get("conversion_rates").getAsJsonObject();

            // Extracción dinámica y Retorno INMEDIATO
            // Usamos la variable 'codigoMoneda' que recibimos arriba
            // Si pides "ARS", busca "ARS". Si pides "BRL", busca "BRL".
            return tasas.get(codigoMoneda).getAsDouble();

        } catch (Exception e) {
            System.out.println("Error en la API: " + e.getMessage());
            // Retorno de emergencia
            // Si algo falla, devolvemos -1 para indicar error
            return -1;
        }
    }
}