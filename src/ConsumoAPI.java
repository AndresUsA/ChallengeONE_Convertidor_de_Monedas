import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConsumoAPI {
    public DatoMoneda convertir(String monedaBase, String objetivoDivisa, double cantidad) {

        String urlBase = "https://v6.exchangerate-api.com/v6/";
        String apiKey = "a7812ff5fec847e64499f4b8";
        URI direccion = URI.create(urlBase + apiKey + "/pair/" + monedaBase + "/" + objetivoDivisa + "/" + cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), DatoMoneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Conversion Fallida...");
        }
    }
}
