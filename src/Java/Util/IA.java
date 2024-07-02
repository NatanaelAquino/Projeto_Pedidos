package Java.Util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.mysql.cj.xdevapi.DbDoc;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonParser;
import com.mysql.cj.xdevapi.JsonValue;

public class IA {

    public void ia() {
        HttpClient client = HttpClient.newHttpClient();
        String key = "?key=AIzaSyCToWuyT0zvau_fBtQVNkZ8-0wfiUyhU7g";
        URI url = URI.create("https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent" + key);

        String jsonBody = """
        {
          "contents": [
            {
              "parts": [
                {
                  "text": "QUERO COME Burger com baixar caloria ESSE E O CARDABIO escolha uma desses opçoes PICANHA Bloomin, Epic cheddar Burger, Truffled Burger. responta em texto plano,seja criativa.ate 2 linhas"
                }
              ]
            }
          ]
        }
        """;

        HttpRequest request = HttpRequest.newBuilder(url)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(jsonBody))
                .build();

        try {
          HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
          DbDoc json = JsonParser.parseDoc(response.body());
          JsonArray candidates = (JsonArray) json.get("candidates");

          JsonValue candidateDoc = candidates.get(0);
          DbDoc candidateJson = JsonParser.parseDoc(candidateDoc.toString());

          JsonValue contentDoc = candidateJson.get("content");
          DbDoc contentJson = JsonParser.parseDoc(contentDoc.toString());

          JsonArray parts = (JsonArray) contentJson.get("parts");

          JsonValue partDoc = parts.get(0);
          DbDoc partJson = JsonParser.parseDoc(partDoc.toString());

          String text = partJson.get("text").toString().replaceAll("\"", "");

          System.out.println(text);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}