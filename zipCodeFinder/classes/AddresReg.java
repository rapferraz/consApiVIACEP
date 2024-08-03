package zipCodeFinder.classes;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AddresReg {

    private int number;
    private String complement;

    public AddresReg(int zipCode, int number, String complement) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        String address = "https://viacep.com.br/ws/" + zipCode + "/json/";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body()
                .replace("complemento", "complemento: " + complement)
                .replace("unidade", "numero: " + number);
        System.out.println(json);
    }
}
