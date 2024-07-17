import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoneda {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/044ddddbffb222c5f2b7dbe8/latest/";

    public double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        String url = API_URL + monedaOrigen;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                // Parse JSON response
                String responseBody = response.body();
                Gson gson = new Gson();
                ConversionRates rates = gson.fromJson(responseBody, ConversionRates.class);

                // Realizar la conversión
                double tasaDeCambio = obtenerTasaDeCambio(rates.conversion_rates, monedaDestino);
                return cantidad * tasaDeCambio;
            } else {
                throw new RuntimeException("Error al consultar la API: " + response.statusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    private double obtenerTasaDeCambio(ConversionRatesRates rates, String monedaDestino) {
        switch (monedaDestino) {
            case "USD":
                return rates.USD;
            case "ARS":
                return rates.ARS;
            case "BRL":
                return rates.BRL;
            case "COP":
                return rates.COP;
            default:
                throw new RuntimeException("Moneda destino no soportada: " + monedaDestino);
        }
    }

    // Clase auxiliar para manejar la estructura JSON de respuesta
    private static class ConversionRates {
        public String result;
        public String documentation;
        public String terms_of_use;
        public String time_last_update_unix;
        public String time_last_update_utc;
        public String time_next_update_unix;
        public String time_next_update_utc;
        public String base_code;
        public ConversionRatesRates conversion_rates;
    }

    private static class ConversionRatesRates {
        public double USD;
        public double ARS;
        public double BRL;
        public double COP;
        // Añadir más monedas según necesidad
    }
}
