package zipCodeFinder.classes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ShowZipCodeInfo {

    private int zipCode;

    public ShowZipCodeInfo(int zipCode) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        String address = "https://viacep.com.br/ws/" + zipCode + "/json/";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);
    }
}
