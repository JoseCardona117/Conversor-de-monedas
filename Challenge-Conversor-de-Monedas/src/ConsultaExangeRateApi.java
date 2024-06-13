import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaExangeRateApi {

    public Moneda cambioMoneda(String target_code, Double cantidadConvertir){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/7e90afb22fd031fc9099adee/pair/MXN/"+target_code+"/"+cantidadConvertir);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al hacer el cambio de moneda");
        }
    }
}
